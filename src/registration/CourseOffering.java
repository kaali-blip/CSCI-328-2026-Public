package registration;

import java.util.ArrayList;
import java.util.List;

public class CourseOffering {
    // Aliases of the same physical section share times, capacity, and seats.
    private static class Section {
        String crn;
        List<MeetingTime> meetings = new ArrayList<>();
        int capacity;
        int enrolled;

        Section(String crn, int capacity) {
            this.crn = crn;
            this.capacity = capacity;
        }
    }

    private final Section section;
    private Course course;

    public CourseOffering(String crn, Course course, int capacity) {
        this.section = new Section(crn, capacity);
        this.course = course;
    }

    // Used by CourseCatalog when an alternate code names the same section.
    CourseOffering(CourseOffering original, Course alternateCourse) {
        this.section = original.section;
        this.course = alternateCourse;
    }

    public String getCrn() { return section.crn; }
    public void setCrn(String crn) { section.crn = crn; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public List<MeetingTime> getMeetings() { return section.meetings; }
    public void setMeetings(List<MeetingTime> meetings) { section.meetings = meetings; }

    public int getCapacity() { return section.capacity; }
    public void setCapacity(int capacity) { section.capacity = capacity; }

    public int getEnrolled() { return section.enrolled; }
    public void setEnrolled(int enrolled) { section.enrolled = enrolled; }

    public boolean hasOpenSeats() { return section.enrolled < section.capacity; }
}
