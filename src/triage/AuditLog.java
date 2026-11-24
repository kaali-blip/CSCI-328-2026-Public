package triage;

public class AuditLog {

    public void record(String action, String detail) {
        System.out.println("[audit] " + action + " :: " + detail);
    }
}
