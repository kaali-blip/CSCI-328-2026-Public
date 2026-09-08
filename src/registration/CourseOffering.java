package registration;

import java.util.ArrayList;
import java.util.List;

public class CourseOffering {

    private String crn;
    private Course course;
    private List<MeetingTime> meetings = new ArrayList<MeetingTime>();
    private int capacity;
    private int enrolled;

    public CourseOffering(String crn, Course course, int capacity) {
        this.crn = crn;
        this.course = course;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public List<MeetingTime> getMeetings() { return meetings; }
    public void setMeetings(List<MeetingTime> meetings) { this.meetings = meetings; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getEnrolled() { return enrolled; }
    public void setEnrolled(int enrolled) { this.enrolled = enrolled; }

    public boolean hasOpenSeats() { return enrolled < capacity; }
}
