package registration;

import java.util.List;

public class DefectTwo {

    public static void main(String[] args) {
        Student alice = new Student("S001", "Alice Reyes", "UNDERGRADUATE");
        Student ben = new Student("S002", "Ben Okafor", "UNDERGRADUATE");

        LegacySisClient.getInstance().seed("S001", "CS201", "B", "2025FA");

        Course cs201 = new Course("CS201", "Data Structures", 4);
        Course cs301 = new Course("CS301", "Object Oriented Design", 3);
        CourseOffering firstOffering = new CourseOffering("20422", cs201, 2);
        CourseOffering secondOffering = new CourseOffering("20515", cs301, 0);
        RegistrationService service = new RegistrationService();

        boolean firstAccepted = service.register(alice, firstOffering);
        final List<String> savedErrors = service.getLastErrors();

        System.out.println("First accepted: " + firstAccepted);
        System.out.println("Saved Alice errors before Ben registers: " + savedErrors);

        boolean secondAccepted = service.register(ben, secondOffering);

        System.out.println("Second accepted: " + secondAccepted);
        System.out.println("Saved Alice errors after Ben registers: " + savedErrors);
    }
}