package registration;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EligibilityChecker {
    private final SisTranscript transcript = new SisTranscript();

    public List<EligibilityReason> check(Student student, CourseOffering offering) {
        List<EligibilityReason> reasons = new ArrayList<>();
        Set<String> passed = transcript.passedCoursesFor(student.getId());
        Course course = offering.getCourse();

        if (passed.contains(course.getCode())) {
            reasons.add(new EligibilityReason(EligibilityRule.ALREADY_PASSED,
                    "Already completed " + course.getCode()));
        }

        Set<String> missing = new LinkedHashSet<>();
        for (String prerequisite : course.getPrerequisites()) {
            if (!passed.contains(prerequisite)) {
                missing.add(prerequisite);
            }
        }
        if (!missing.isEmpty()) {
            reasons.add(new EligibilityReason(EligibilityRule.PREREQUISITE,
                    "Missing prerequisites: " + String.join(", ", missing)));
        }

        Set<String> conflicts = new LinkedHashSet<>();
        for (CourseOffering current : student.getCurrentEnrollments()) {
            for (MeetingTime existing : current.getMeetings()) {
                for (MeetingTime proposed : offering.getMeetings()) {
                    if (existing.overlaps(proposed)) {
                        conflicts.add(current.getCourse().getCode());
                    }
                }
            }
        }
        if (!conflicts.isEmpty()) {
            reasons.add(new EligibilityReason(EligibilityRule.TIME_CONFLICT,
                    "Time conflict with " + String.join(", ", conflicts)));
        }

        int cap = Config.getInt("max_credits", 18);
        int total = student.getCurrentCredits() + course.getCredits();
        if (total > cap) {
            reasons.add(new EligibilityReason(EligibilityRule.CREDIT_CAP,
                    "Would total " + total + " credits, limit is " + cap));
        }

        if (!offering.hasOpenSeats()) {
            reasons.add(new EligibilityReason(EligibilityRule.SECTION_FULL,
                    "Section is full"));
        }

        return List.copyOf(reasons);
    }
}
