package registration;

public class DefectOne {

    public static void main(String[] args) {
        LegacySisClient sis = LegacySisClient.getInstance();
        sis.seed("S001", "CS101", "B", "2025SP");

        boolean safeVersion = args.length > 0 && args[0].equals("safe");

        if (safeVersion) {
            System.out.println("SAFE VERSION: I on unrelated HIST101");
            sis.seed("S001", "HIST101", "I", "2025FA");
        } else {
            System.out.println("CRASH VERSION: I on prerequisite CS101");
            sis.seed("S001", "CS101", "I", "2025FA");
        }

        Student student = new Student("S001", "Alice Reyes", "UNDERGRADUATE");
        Course cs201 = new Course("CS201", "Data Structures", 4);
        cs201.getPrerequisites().add("CS101");
        CourseOffering offering = new CourseOffering("10422", cs201, 2);
        RegistrationService service = new RegistrationService();

        System.out.println(service.describeResult(student, offering));
    }
}