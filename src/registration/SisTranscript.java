package registration;

import java.util.HashSet;
import java.util.Set;

public class SisTranscript {
    public Set<String> passedCoursesFor(String studentId) {
        String[][] rows = LegacySisClient.getInstance().fetchGradeRows(studentId);
        Set<String> passed = new HashSet<>();
        for (String[] row : rows) {
            if (Grade.valueOf(row[1]).isPassing()) {
                passed.add(row[0]);
            }
        }
        return Set.copyOf(passed);
    }
}
