package library;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface LateFeePolicy {
    BigDecimal calculateFee(LocalDate dueDate, LocalDate returnDate);
}