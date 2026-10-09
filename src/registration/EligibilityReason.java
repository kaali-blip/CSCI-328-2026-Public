package registration;

import java.util.Objects;

public record EligibilityReason(EligibilityRule rule, String message) {
    public EligibilityReason {
        Objects.requireNonNull(rule);
        Objects.requireNonNull(message);
    }

    public boolean canRequestOverride() {
        return rule.canRequestOverride();
    }
}
