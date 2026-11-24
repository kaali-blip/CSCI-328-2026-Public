package triage;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class TriageDemo {

    public static void main(String[] args)
            throws InterruptedException {

        WaitlistManager.settings.clear();

        WaitlistManager.settings.put(
                "max_daily_promotions", "1");

        WaitlistManager manager = new WaitlistManager(
                new AuditLog(),
                new NotificationGateway());

        manager.addToWaitlist("S001", "CS301", 1);
        manager.addToWaitlist("S002", "CS301", 2);

        Thread first = new Thread(() ->
                manager.promoteNext("CS301"));

        Thread second = new Thread(() ->
                manager.promoteNext("CS301"));

        first.start();
        second.start();

        first.join();
        second.join();

        int remaining = manager.waitlistSize("CS301");

        System.out.println("Remaining students: " + remaining);

        if (remaining != 1) {
            throw new AssertionError("Promotion cap failed");
        }

        System.out.println("Promotion cap test passed");

        manager.clearDailyPromotions();

        System.out.println("Promotion after reset: "
                + manager.promoteNext("CS301"));

        // Demonstrate the equality contract defect.
        WaitlistEntry a = new WaitlistEntry(
                "S003", "CS302", 1, Instant.now());

        WaitlistEntry b = new WaitlistEntry(
                "S003", "CS302", 1, Instant.now());

        Set<WaitlistEntry> entries = new HashSet<>();
        entries.add(a);
        entries.add(b);

        System.out.println("Entries equal: " + a.equals(b));
        System.out.println("HashSet size: " + entries.size());
    }
}
