package library;

import java.util.Objects;

public class LibraryItem {
    private final String title;
    private final LateFeePolicy lateFeePolicy;

    public LibraryItem(String title, LateFeePolicy lateFeePolicy) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }

        this.title = title;
        this.lateFeePolicy = Objects.requireNonNull(
                lateFeePolicy,
                "Late fee policy is required"
        );
    }

    public String getTitle() {
        return title;
    }

    public LateFeePolicy getLateFeePolicy() {
        return lateFeePolicy;
    }
}