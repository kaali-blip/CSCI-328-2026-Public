package registration;

public class MeetingTimeContractsDemo {
    public static void main(String[] args) {
        MeetingTime first = new MeetingTime("MON", 540, 630);
        MeetingTime equalTime = new MeetingTime("MON", 540, 630);
        System.out.println("equals: " + first.equals(equalTime));
        System.out.println("HashSet contains equal time: " + new java.util.HashSet<>(java.util.List.of(first)).contains(equalTime));
    }
}
