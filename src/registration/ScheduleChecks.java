package registration;

import java.util.List;

public class ScheduleChecks {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static boolean hasRule(ScheduleResult result, EligibilityRule rule) {
        return result.problems().stream().anyMatch(p -> p.rule() == rule);
    }

    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();
        catalog.crossList("CS301", "MATH301");
        catalog.crossList("MATH301", "STAT301"); // third code keeps same identity
        check(catalog.sameCourse("CS301", "STAT301"), "Third alias not recognized");
        RegistrationService service = new RegistrationService(catalog);

        Course cs301 = new Course("CS301", "Design", 3);
        Course math301 = new Course("MATH301", "Design", 3);
        CourseOffering cs = new CourseOffering("30001", cs301, 1);
        cs.getMeetings().add(new MeetingTime("TUE", 540, 600));
        CourseOffering math = catalog.crossListedOffering(cs, math301);
        Student first = new Student("SCHED01", "First", "UNDERGRADUATE");
        Student second = new Student("SCHED02", "Second", "UNDERGRADUATE");

        check(service.register(first, cs), "First section registration failed");
        check(cs.getEnrolled() == 1 && math.getEnrolled() == 1,
                "Cross-listed sections must share the seat count");
        check(!service.register(second, math), "Cross-listed alias bypassed capacity");
        check(service.checkEligibility(first, math).stream()
                .anyMatch(r -> r.rule() == EligibilityRule.ALREADY_ENROLLED),
                "Existing enrollment in alias was missed");
        check(service.getLastReasons().size() == 1, "Planning changed registration reasons");

        LegacySisClient.getInstance().seed("SCHED03", "MATH301", "B", "2025FA");
        Student passed = new Student("SCHED03", "Passed", "UNDERGRADUATE");
        check(service.checkEligibility(passed, cs).stream()
                .anyMatch(r -> r.rule() == EligibilityRule.ALREADY_PASSED),
                "Passing alternate code must count as same course");
        Course dependent = new Course("CS401", "Advanced", 3);
        dependent.getPrerequisites().add("CS301");
        CourseOffering advanced = new CourseOffering("40001", dependent, 5);
        check(service.checkEligibility(passed, advanced).isEmpty(),
                "Passing alternate code did not satisfy prerequisite");

        CourseOffering other = new CourseOffering("50001",
                new Course("HIST101", "History", 4), 5);
        other.getMeetings().add(new MeetingTime("TUE", 570, 620));
        Student planning = new Student("SCHED04", "Planning", "UNDERGRADUATE");
        ScheduleResult pair = service.checkSchedule(planning, List.of(cs, other));
        check(hasRule(pair, EligibilityRule.PROPOSED_TIME_CONFLICT),
                "Proposed-versus-proposed time overlap was missed");
        check(pair.problems().stream()
                .filter(p -> p.rule() == EligibilityRule.PROPOSED_TIME_CONFLICT)
                .allMatch(p -> p.sections().size() == 2),
                "Two-section issue did not name both sections");

        int waitlistBefore = service.getWaitlist().size("30001");
        ScheduleResult duplicates = service.checkSchedule(planning, List.of(cs, math));
        check(hasRule(duplicates, EligibilityRule.DUPLICATE_PROPOSED_COURSE),
                "Two codes for one section were not rejected");
        check(duplicates.weeklyMeetings().size() == 1,
                "Identical MeetingTime values were not deduplicated");
        check(!duplicates.eligible(), "Invalid schedule was accepted");
        check(planning.getCurrentEnrollments().isEmpty()
                && cs.getEnrolled() == 1
                && service.getWaitlist().size("30001") == waitlistBefore,
                "Checking schedule changed registration or waitlist state");

        CourseOffering c1 = new CourseOffering("60001", new Course("A101", "A", 10), 5);
        CourseOffering c2 = new CourseOffering("60002", new Course("B101", "B", 10), 5);
        ScheduleResult credits = service.checkSchedule(planning, List.of(c1, c2));
        check(hasRule(credits, EligibilityRule.CREDIT_CAP),
                "Combined credit cap was not checked");
        check(credits.problems().stream().anyMatch(p -> p.rule() == EligibilityRule.CREDIT_CAP
                && p.sections().size() == 2), "Whole-plan credit problem is missing context");

        MeetingTime slot = new MeetingTime("FRI", 540, 600);
        MeetingTime same = new MeetingTime("FRI", 540, 600);
        check(slot.equals(same) && slot.hashCode() == same.hashCode(),
                "MeetingTime record should have matching equals and hashCode");
        check(!slot.overlaps(new MeetingTime("FRI", 600, 660)),
                "MeetingTime.overlaps changed its existing meaning");
        System.out.println("All schedule checks passed.");
    }
}
