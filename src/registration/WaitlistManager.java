package registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaitlistManager {

    private Map<String, List<String>> byOffering = new HashMap<String, List<String>>();

    public void add(String crn, String studentId) {
        List<String> queue = byOffering.get(crn);
        if (queue == null) {
            queue = new ArrayList<String>();
            byOffering.put(crn, queue);
        }
        queue.add(studentId);
    }

    public String promoteNext(String crn) {
        List<String> queue = byOffering.get(crn);
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public int positionOf(String crn, String studentId) {
        List<String> queue = byOffering.get(crn);
        if (queue == null) return -1;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(studentId)) return i + 1;
        }
        return -1;
    }

    public int size(String crn) {
        List<String> queue = byOffering.get(crn);
        return queue == null ? 0 : queue.size();
    }

    public Map<String, List<String>> getByOffering() { return byOffering; }
}
