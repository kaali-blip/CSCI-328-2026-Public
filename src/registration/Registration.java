package registration;

public class Registration {

    private String studentId;
    private String crn;
    private String status;

    private Integer waitlistPosition;
    private String enrolledCrn;
    private Long droppedAtEpoch;
    private String dropReason;

    public Registration(String studentId, String crn, String status) {
        this.studentId = studentId;
        this.crn = crn;
        this.status = status;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getWaitlistPosition() { return waitlistPosition; }
    public void setWaitlistPosition(Integer waitlistPosition) { this.waitlistPosition = waitlistPosition; }

    public String getEnrolledCrn() { return enrolledCrn; }
    public void setEnrolledCrn(String enrolledCrn) { this.enrolledCrn = enrolledCrn; }

    public Long getDroppedAtEpoch() { return droppedAtEpoch; }
    public void setDroppedAtEpoch(Long droppedAtEpoch) { this.droppedAtEpoch = droppedAtEpoch; }

    public String getDropReason() { return dropReason; }
    public void setDropReason(String dropReason) { this.dropReason = dropReason; }
}
