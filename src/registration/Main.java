package registration;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LegacySisClient sis = LegacySisClient.getInstance();
        sis.seed("S001", "CS101", "B", "2025FA");
        sis.seed("S002", "CS101", "F", "2025FA");

        Course cs101 = new Course("CS101", "Intro to Programming", 4);

        Course cs201 = new Course("CS201", "Data Structures", 4);
        cs201.getPrerequisites().add("CS101");

        Course cs301 = new Course("CS301", "Object Oriented Design", 3);
        cs301.getPrerequisites().add("CS201");
        Course math301 = new Course("MATH301", "Cross-listed Object Oriented Design", 3);
        math301.getPrerequisites().add("CS201");

        CourseCatalog catalog = new CourseCatalog();
        catalog.crossList("CS301", "MATH301");

        CourseOffering ds = new CourseOffering("10422", cs201, 2);
        ds.getMeetings().add(new MeetingTime("MON", 540, 630));
        ds.getMeetings().add(new MeetingTime("WED", 540, 630));

        CourseOffering ood = new CourseOffering("10515", cs301, 30);
        ood.getMeetings().add(new MeetingTime("MON", 600, 690));
        CourseOffering mathOod = catalog.crossListedOffering(ood, math301);

        Student alice = new Student("S001", "Alice Reyes", "UNDERGRADUATE");
        Student ben = new Student("S002", "Ben Okafor", "UNDERGRADUATE");

        RegistrationService service = new RegistrationService(catalog);

        registerAndReport(service, alice, ds);
        registerAndReport(service, ben, ds);
        registerAndReport(service, alice, ood);

        System.out.println();
        System.out.println("Alice is enrolled in: " + Arrays.toString(
                alice.getCurrentEnrollments().stream()
                        .map(o -> o.getCourse().getCode())
                        .toArray()));

        Roster roster = new Roster("10422", 2);
        roster.getStudents().put(alice.getId(), alice);
        System.out.println();
        System.out.print(service.formatRosterForAdvising(roster));

        System.out.println("\nCROSS-LISTING EXAMPLE");
        sis.seed("S003", "MATH301", "B", "2025FA");
        Student chris = new Student("S003", "Chris Kim", "UNDERGRADUATE");
        System.out.println(service.describeResult(chris, ood));
        // CS301 prerequisite can be met by a passing grade in MATH301.
        Course advanced = new Course("CS401", "Advanced Design", 3);
        advanced.getPrerequisites().add("CS301");
        CourseOffering advancedSection = new CourseOffering("10888", advanced, 20);
        System.out.println(service.describeResult(chris, advancedSection));
        sis.seed("S005", "CS201", "B", "2025FA");
        Student emma = new Student("S005", "Emma Park", "UNDERGRADUATE");
        registerAndReport(service, emma, mathOod);
        System.out.println("Shared section seat count (CS301 / MATH301): "
                + ood.getEnrolled() + " / " + mathOod.getEnrolled());
        System.out.println(service.describeResult(emma, ood));

        System.out.println("\nWHOLE-SCHEDULE EXAMPLE");
        sis.seed("S004", "CS201", "B", "2025FA");
        Student dana = new Student("S004", "Dana Lee", "UNDERGRADUATE");
        CourseOffering history = new CourseOffering("10999",
                new Course("HIST101", "History", 3), 20);
        history.getMeetings().add(new MeetingTime("MON", 630, 720));
        ScheduleResult schedule = service.checkSchedule(dana, List.of(history, ood, mathOod));
        for (ScheduleProblem problem : schedule.problems()) {
            System.out.println(problem.rule() + ": " + problem.message());
        }
        System.out.println("Distinct weekly meeting slots:");
        for (MeetingTime meeting : schedule.weeklyMeetings()) {
            System.out.println("  " + meeting);
        }
    }

    private static void registerAndReport(RegistrationService service,
                                          Student student, CourseOffering offering) {
        if (service.register(student, offering)) {
            System.out.println(student.getName() + " registered for "
                    + offering.getCourse().getCode());
        } else {
            System.out.println(service.describeResult(student, offering));
        }
    }
}
