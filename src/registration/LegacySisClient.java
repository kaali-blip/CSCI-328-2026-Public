package registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stand-in for the university's student information system.
 * Treat this class as vendor code: you cannot change it.
 */
public class LegacySisClient {

    private static LegacySisClient instance;

    private final Map<String, List<String[]>> rows = new HashMap<String, List<String[]>>();

    private LegacySisClient() { }

    public static LegacySisClient getInstance() {
        if (instance == null) {
            instance = new LegacySisClient();
        }
        return instance;
    }

    /** Test seam used by Main to populate fake data. */
    public void seed(String studentId, String courseCode, String grade, String term) {
        List<String[]> forStudent = rows.get(studentId);
        if (forStudent == null) {
            forStudent = new ArrayList<String[]>();
            rows.put(studentId, forStudent);
        }
        forStudent.add(new String[] { courseCode, grade, term });
    }

    /** Returns { courseCode, letterGrade, term } triples. */
    public String[][] fetchGradeRows(String studentId) {
        List<String[]> forStudent = rows.get(studentId);
        if (forStudent == null) {
            return new String[0][];
        }
        return forStudent.toArray(new String[0][]);
    }
}
