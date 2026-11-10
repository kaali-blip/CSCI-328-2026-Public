package registration;

public class FlatList {
    public static void main(String[] args) {
        Student student = new Student(
                "S007", "Dana Whitfield", "UNDERGRADUATE");

        LegacySisClient sis = LegacySisClient.getInstance();
        sis.seed("S007", "CS201", "B", "2025FA");
        sis.seed("S007", "MATH160", "A", "2025FA");

        Course cs301 = new Course(
                "CS301", "Object Oriented Design", 3);
        CourseOffering offering =
                new CourseOffering("10515", cs301, 30);

        cs301.getPrerequisites().add("CS201");
        cs301.getPrerequisites().add("MATH150");
        cs301.getPrerequisites().add("MATH160");

        System.out.println(
                new RegistrationService().describeResult(
                        student, offering));
    }
}