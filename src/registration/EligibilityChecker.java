package registration;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EligibilityChecker {
    private final SisTranscript transcript = new SisTranscript();
    private final CourseCatalog catalog;

    public EligibilityChecker() {
        this(new CourseCatalog());
    }

    public EligibilityChecker(CourseCatalog catalog) {
        this.catalog = catalog;
    }

    public List<EligibilityReason> check(Student student, CourseOffering offering) {
        List<EligibilityReason> reasons = new ArrayList<>();
        Set<String> passed = transcript.passedCoursesFor(student.getId());
        Course course = offering.getCourse();

        if (hasPassed(passed, course.getCode())) {
            reasons.add(new EligibilityReason(EligibilityRule.ALREADY_PASSED,
                    "Already completed " + course.getCode()));
        }

        Set<String> missing = new LinkedHashSet<>();
        for (String prerequisite : course.getPrerequisites()) {
            if (!hasPassed(passed, prerequisite)) {
                missing.add(prerequisite);
            }
        }
        if (!missing.isEmpty()) {
            reasons.add(new EligibilityReason(EligibilityRule.PREREQUISITE,
                    "Missing prerequisites: " + String.join(", ", missing)));
        }

        Set<String> alreadyEnrolled = new LinkedHashSet<>();
        Set<String> conflicts = new LinkedHashSet<>();
        for (CourseOffering current : student.getCurrentEnrollments()) {
            if (catalog.sameCourse(current.getCourse().getCode(), course.getCode())) {
                alreadyEnrolled.add(current.getCourse().getCode());
            }
            for (MeetingTime existing : current.getMeetings()) {
                for (MeetingTime proposed : offering.getMeetings()) {
                    if (existing.overlaps(proposed)) {
                        conflicts.add(current.getCourse().getCode());
                    }
                }
            }
        }
        if (!alreadyEnrolled.isEmpty()) {
            reasons.add(new EligibilityReason(EligibilityRule.ALREADY_ENROLLED,
                    "Already enrolled in equivalent course: "
                            + String.join(", ", alreadyEnrolled)));
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

    private boolean hasPassed(Set<String> passedCodes, String requiredCode) {
        for (String completedCode : passedCodes) {
            if (catalog.sameCourse(completedCode, requiredCode)) {
                return true;
            }
        }
        return false;
    }
}
