package registration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Checks a proposed set without registering or waitlisting anyone. */
public class SchedulePlanner {
    private final CourseCatalog catalog;
    private final EligibilityChecker eligibility;

    public SchedulePlanner(CourseCatalog catalog, EligibilityChecker eligibility) {
        this.catalog = catalog;
        this.eligibility = eligibility;
    }

    public ScheduleResult check(Student student, List<CourseOffering> proposed) {
        List<CourseOffering> sections = List.copyOf(proposed);
        List<ScheduleProblem> problems = new ArrayList<>();
        Set<MeetingTime> uniqueMeetings = new LinkedHashSet<>();

        for (CourseOffering section : sections) {
            uniqueMeetings.addAll(section.getMeetings());
            for (EligibilityReason reason : eligibility.check(student, section)) {
                // Credit cap must be calculated once for the whole plan.
                if (reason.rule() != EligibilityRule.CREDIT_CAP) {
                    problems.add(new ScheduleProblem(reason.rule(), reason.message(),
                            List.of(section)));
                }
            }
        }

        // A problem between two new sections cannot be found by a one-section check.
        for (int i = 0; i < sections.size(); i++) {
            for (int j = i + 1; j < sections.size(); j++) {
                CourseOffering first = sections.get(i);
                CourseOffering second = sections.get(j);
                if (catalog.sameCourse(first.getCourse().getCode(),
                        second.getCourse().getCode())) {
                    problems.add(new ScheduleProblem(EligibilityRule.DUPLICATE_PROPOSED_COURSE,
                            "Same course listed twice: " + first.getCourse().getCode()
                                    + " and " + second.getCourse().getCode(),
                            List.of(first, second)));
                } else if (overlap(first, second)) {
                    problems.add(new ScheduleProblem(EligibilityRule.PROPOSED_TIME_CONFLICT,
                            "Time conflict between " + first.getCourse().getCode()
                                    + " and " + second.getCourse().getCode(),
                            List.of(first, second)));
                }
            }
        }

        Set<CourseCatalog.CourseId> counted = new HashSet<>();
        for (CourseOffering current : student.getCurrentEnrollments()) {
            counted.add(catalog.identityOf(current.getCourse().getCode()));
        }
        int total = student.getCurrentCredits();
        for (CourseOffering section : sections) {
            if (counted.add(catalog.identityOf(section.getCourse().getCode()))) {
                total += section.getCourse().getCredits();
            }
        }
        int cap = Config.getInt("max_credits", 18);
        if (total > cap) {
            problems.add(new ScheduleProblem(EligibilityRule.CREDIT_CAP,
                    "Whole schedule would total " + total + " credits, limit is " + cap,
                    sections));
        }

        return new ScheduleResult(problems, new ArrayList<>(uniqueMeetings));
    }

    private boolean overlap(CourseOffering first, CourseOffering second) {
        for (MeetingTime a : first.getMeetings()) {
            for (MeetingTime b : second.getMeetings()) {
                if (a.overlaps(b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
