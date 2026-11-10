package registration;

import java.util.Objects;

/** Immutable value: records give matching equals and hashCode for Set use. */
public record MeetingTime(String day, int startMinutes, int endMinutes) {
    public MeetingTime {
        Objects.requireNonNull(day);
    }

    // Keep the existing getter names for current callers.
    public String getDay() { return day; }
    public int getStartMinutes() { return startMinutes; }
    public int getEndMinutes() { return endMinutes; }

    // Same overlap rule as before. Touching end/start times do not overlap.
    public boolean overlaps(MeetingTime other) {
        return day.equals(other.day)
                && startMinutes < other.endMinutes
                && other.startMinutes < endMinutes;
    }

    @Override
    public String toString() {
        return day + " " + startMinutes + "-" + endMinutes;
    }
}
