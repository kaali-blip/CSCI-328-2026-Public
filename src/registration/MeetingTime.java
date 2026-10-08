package registration;

public record MeetingTime(String day, int startMinutes, int endMinutes) {

    public boolean overlaps(MeetingTime other) {
        return day.equals(other.day)
                && startMinutes < other.endMinutes
                && other.startMinutes < endMinutes;
    }
}
