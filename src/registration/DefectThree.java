package registration;

public class DefectThree {

    public static void main(String[] args) {
        Student student = new Student("S001", "Alice Reyes", "UNDERGRADUATE");
        RegistrationService service = new RegistrationService();

        for (int i = 1; i <= 4; i++) {
            Course existing = new Course("PREP" + i, "Existing course " + i, 4);
            student.enroll(new CourseOffering("3000" + i, existing, 30));
        }

        Course cs201 = new Course("CS201", "Data Structures", 4);
        final CourseOffering nextOffering = new CourseOffering("30422", cs201, 2);

        System.out.println("Current credits: " + student.getCurrentCredits());
        System.out.println("Before change - CRN " + nextOffering.getCrn());
        System.out.println(service.describeResult(student, nextOffering));

        Config.settings.put("max_credits", "20");

        System.out.println("After change - same CRN " + nextOffering.getCrn());
        System.out.println(service.describeResult(student, nextOffering));
        System.out.println("Current credits after acceptance: "
                + student.getCurrentCredits());
    }
}