package library;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final LibraryItem item;
    private final LocalDate dueDate;

    public Loan(LibraryItem item, LocalDate dueDate) {
        this.item = Objects.requireNonNull(item, "Item is required");
        this.dueDate = Objects.requireNonNull(dueDate, "Due date is required");
    }

    public LibraryItem getItem() {
        return item;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}