package registration;

public class TranscriptEntry {

    private String courseCode;
    private Grade grade;
    private int term;

    public TranscriptEntry(String courseCode, Grade grade, int term) {
        this.courseCode = courseCode;
        this.grade = grade;
        this.term = term;
    }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }

    public int getTerm() { return term; }
    public void setTerm(int term) { this.term = term; }
}
