package registration;

public class MeetingTime {

    private String day;
    private int startMinutes;
    private int endMinutes;

    public MeetingTime(String day, int startMinutes, int endMinutes) {
        this.day = day;
        this.startMinutes = startMinutes;
        this.endMinutes = endMinutes;
    }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public int getStartMinutes() { return startMinutes; }
    public void setStartMinutes(int startMinutes) { this.startMinutes = startMinutes; }

    public int getEndMinutes() { return endMinutes; }
    public void setEndMinutes(int endMinutes) { this.endMinutes = endMinutes; }

    public boolean overlaps(MeetingTime other) {
        return day.equals(other.day)
                && startMinutes < other.endMinutes
                && other.startMinutes < endMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeetingTime)) return false;
        MeetingTime that = (MeetingTime) o;
        return startMinutes == that.startMinutes
                && endMinutes == that.endMinutes
                && day.equals(that.day);
    }

    @Override
    public String toString() {
        return day + " " + startMinutes + "-" + endMinutes;
    }
}
