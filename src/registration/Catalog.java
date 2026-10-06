package registration;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    public static void main(String[] args) {
        attack1();
        attack2();
    }

    private static Course createCourse(List<String> prerequisites) {
        Course course = new Course("CS201", "Data Structures", 4);
        course.setPrerequisites(prerequisites);
        return course;
    }

    private static Student passingStudent(String id, String name) {
        LegacySisClient.getInstance().seed(id, "CS101", "B", "2025FA");
        return new Student(id, name, "UNDERGRADUATE");
    }

    private static void syncMath150(Course course) {
        course.getPrerequisites().add("MATH150");
    }

    private static void attack1() {
        System.out.println("Attack 1: through the getter");
        ArrayList<String> prerequisites = new ArrayList<>();
        prerequisites.add("CS101");
        Course course = createCourse(prerequisites);
        CourseOffering section = new CourseOffering("20101", course, 2);
        Student first = passingStudent("CG001", "Getter First");
        Student second = passingStudent("CG002", "Getter Second");
        RegistrationService service = new RegistrationService();

        System.out.println(service.describeResult(first, section));
        try {
            syncMath150(course);
            System.out.println("Getter sync completed.");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Getter sync blocked: UnsupportedOperationException");
        }
        System.out.println(service.describeResult(second, section));
        System.out.println();
    }

    private static void attack2() {
        System.out.println("Attack 2: through the held list");
        ArrayList<String> heldList = new ArrayList<>();
        heldList.add("CS101");
        Course course = createCourse(heldList);
        CourseOffering section = new CourseOffering("20102", course, 2);
        Student first = passingStudent("CA001", "Alias First");
        Student second = passingStudent("CA002", "Alias Second");
        RegistrationService service = new RegistrationService();

        System.out.println(service.describeResult(first, section));
        heldList.add("MATH150");
        System.out.println(service.describeResult(second, section));
        System.out.println("Course prerequisites: " + course.getPrerequisites());
        System.out.println();
    }
}
