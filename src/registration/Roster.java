package registration;

import java.util.HashMap;
import java.util.Map;

public class Roster {

    private String crn;
    private int capacity;
    private Map<String, Student> students = new HashMap<String, Student>();

    public Roster(String crn, int capacity) {
        this.crn = crn;
        this.capacity = capacity;
    }

    public String getCrn() { return crn; }
    public void setCrn(String crn) { this.crn = crn; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Map<String, Student> getStudents() { return students; }
    public void setStudents(Map<String, Student> students) { this.students = students; }
}
