package registration;

import java.util.List;
import java.util.Objects;

/** A problem can point to one section, two sections, or the whole plan. */
public record ScheduleProblem(EligibilityRule rule, String message,
                              List<CourseOffering> sections) {
    public ScheduleProblem {
        Objects.requireNonNull(rule);
        Objects.requireNonNull(message);
        sections = List.copyOf(sections);
    }

    public boolean canRequestOverride() {
        return rule.canRequestOverride();
    }
}
