package registration;

public class NotificationGateway {

    public void send(String studentId, String subject, String body) {
        System.out.println("[notify] " + studentId + " | " + subject + " | " + body);
    }
}
