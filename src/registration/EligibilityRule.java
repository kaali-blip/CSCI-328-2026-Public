package registration;

public enum EligibilityRule {
    ALREADY_PASSED(false),
    PREREQUISITE(true),
    TIME_CONFLICT(false),
    CREDIT_CAP(true),
    SECTION_FULL(false);

    private final boolean overrideAllowed;

    EligibilityRule(boolean overrideAllowed) {
        this.overrideAllowed = overrideAllowed;
    }

    public boolean canRequestOverride() {
        return overrideAllowed;
    }
}
