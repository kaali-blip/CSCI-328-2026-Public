package registration;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static Map<String, String> settings = new HashMap<String, String>();

    static {
        settings.put("max_credits", "18");
        settings.put("waitlist_enabled", "true");
        settings.put("promotion_message", "A seat has opened in {course}.");
    }

    public static int getInt(String key, int fallback) {
        String raw = settings.get(key);
        if (raw == null) return fallback;
        return Integer.parseInt(raw);
    }
}
