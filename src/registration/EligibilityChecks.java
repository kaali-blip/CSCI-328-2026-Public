package registration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EligibilityChecks {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        Student student = new Student("TEST01", "Test Student", "UNDERGRADUATE");
        CourseOffering current = new CourseOffering("T1",
                new Course("CURRENT", "Current", 18), 10);
        current.getMeetings().add(new MeetingTime("MON", 540, 630));
        student.enroll(current);

        Course course = new Course("TARGET", "Target", 4);
        course.getPrerequisites().addAll(List.of("PRE1", "PRE2"));
        CourseOffering target = new CourseOffering("T2", course, 1);
        target.getMeetings().add(new MeetingTime("MON", 600, 690));

        List<EligibilityReason> reasons = service.checkEligibility(student, target);
        check(reasons.size() == 3, "Expected three reasons");
        check(reasons.stream().map(EligibilityReason::rule).collect(Collectors.toSet())
                .equals(Set.of(EligibilityRule.PREREQUISITE, EligibilityRule.TIME_CONFLICT,
                        EligibilityRule.CREDIT_CAP)), "Wrong rule identifiers");
        for (EligibilityRule rule : EligibilityRule.values()) {
            check(rule.canRequestOverride() == (rule == EligibilityRule.PREREQUISITE
                    || rule == EligibilityRule.CREDIT_CAP), "Wrong override permission");
        }

        LegacySisClient.getInstance().seed("TEST01", "TARGET", "B", "2025FA");
        target.setEnrolled(1);
        reasons = service.checkEligibility(student, target);
        check(reasons.size() == 5, "Expected all five reasons");
        check(reasons.equals(service.checkEligibility(student, target)), "Query changed");
        check(service.describeResult(student, target).equals(
                service.describeResult(student, target)), "Description changed");
        check(student.getCurrentEnrollments().size() == 1
                && student.getCurrentCredits() == 18 && target.getEnrolled() == 1
                && service.getWaitlist().size("T2") == 0
                && service.getLastReasons().isEmpty(), "Query changed state");
        check(!service.register(student, target)
                && service.getWaitlist().size("T2") == 0, "Invalid student was waitlisted");

        Student ready = new Student("TEST02", "Ready Student", "UNDERGRADUATE");
        CourseOffering open = new CourseOffering("T3", new Course("OPEN", "Open", 4), 1);
        check(service.checkEligibility(ready, open).isEmpty(), "Eligible query failed");
        check(service.describeResult(ready, open).equals(service.describeResult(ready, open))
                && ready.getCurrentEnrollments().isEmpty()
                && open.getEnrolled() == 0, "Planning enrolled student");
        check(service.register(ready, open)
                && ready.getCurrentEnrollments().size() == 1
                && open.getEnrolled() == 1, "Registration failed");
        Student waiting = new Student("TEST03", "Waiting Student", "UNDERGRADUATE");
        check(!service.register(waiting, open)
                && service.getWaitlist().positionOf("T3", "TEST03") == 1,
                "Full-only registration did not waitlist");
        System.out.println("All eligibility checks passed.");
    }
}
