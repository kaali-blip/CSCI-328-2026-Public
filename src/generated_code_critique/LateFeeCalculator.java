package library;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LateFeeCalculator {

    public BigDecimal calculate(Loan loan, LocalDate returnDate) {
        Objects.requireNonNull(loan, "Loan is required");

        return loan.getItem()
                .getLateFeePolicy()
                .calculateFee(loan.getDueDate(), returnDate);
    }
}