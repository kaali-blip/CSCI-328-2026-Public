package registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private final EligibilityChecker eligibility = new EligibilityChecker();
    private List<EligibilityReason> lastReasons = List.of();

    private final WaitlistManager waitlist = new WaitlistManager();
    private final AuditLog audit = new AuditLog();
    private final NotificationGateway notifications = new NotificationGateway();

    public List<EligibilityReason> getLastReasons() {
        return lastReasons;
    }

    public List<String> getLastErrors() {
        List<String> messages = new ArrayList<>();
        for (EligibilityReason reason : lastReasons) {
            messages.add(reason.message());
        }
        return List.copyOf(messages);
    }

    public WaitlistManager getWaitlist() {
        return waitlist;
    }

    public List<EligibilityReason> checkEligibility(Student student, CourseOffering offering) {
        return eligibility.check(student, offering);
    }

    public boolean register(Student student, CourseOffering offering) {
        lastReasons = checkEligibility(student, offering);

        if (!lastReasons.isEmpty()) {
            // Waitlist only when fullness is the only failure.
            if (lastReasons.size() == 1
                    && lastReasons.get(0).rule() == EligibilityRule.SECTION_FULL
                    && "true".equals(Config.settings.get("waitlist_enabled"))) {
                if (waitlist.positionOf(offering.getCrn(), student.getId()) == -1) {
                    waitlist.add(offering.getCrn(), student.getId());
                    audit.record("WAITLISTED", student.getId() + " -> " + offering.getCrn());
                }
                lastReasons = List.of(new EligibilityReason(EligibilityRule.SECTION_FULL,
                        "Section full; added to waitlist at position "
                        + waitlist.positionOf(offering.getCrn(), student.getId())));
            }
            return false;
        }

        student.enroll(offering);
        audit.record("ENROLLED", student.getId() + " -> " + offering.getCrn());
        notifications.send(student.getId(), "Enrollment confirmed",
                "You are enrolled in " + offering.getCourse().getCode() + ".");
        return true;
    }

    public void drop(Student student, CourseOffering offering) {
        student.getCurrentEnrollments().remove(offering);
        offering.setEnrolled(offering.getEnrolled() - 1);
        audit.record("DROPPED", student.getId() + " -> " + offering.getCrn());

        String promoted = waitlist.promoteNext(offering.getCrn());
        if (promoted != null) {
            String template = Config.settings.get("promotion_message");
            String body = template.replace("{course}", offering.getCourse().getCode());
            notifications.send(promoted, "Seat available", body);
        }
    }

    // Planning query: never registers or waitlists the student.
    public String describeResult(Student student, CourseOffering offering) {
        List<EligibilityReason> reasons = checkEligibility(student, offering);
        if (reasons.isEmpty()) {
            return student.getName() + " could register for " + offering.getCourse().getCode();
        }
        StringBuilder out = new StringBuilder(student.getName() + " could not register:");
        for (EligibilityReason reason : reasons) {
            out.append("\n  - ").append(reason.rule()).append(": ").append(reason.message());
            if (reason.canRequestOverride()) {
                out.append(" [request override]");
            }
        }
        return out.toString();
    }

    public String formatRosterForAdvising(Roster roster) {
        StringBuilder out = new StringBuilder("Roster " + roster.getCrn() + ":\n");
        for (Student s : roster.getStudents().values()) {
            out.append("  ").append(s.getId()).append(" ").append(s.getName())
               .append(" (").append(s.getCurrentCredits()).append(" cr)\n");
        }
        return out.toString();
    }

    public String exportRosterCsv(Roster roster) {
        StringBuilder out = new StringBuilder("student_id,name,credits\n");
        for (Student s : roster.getStudents().values()) {
            out.append(s.getId()).append(",").append(s.getName()).append(",")
               .append(s.getCurrentCredits()).append("\n");
        }
        return out.toString();
    }
}
