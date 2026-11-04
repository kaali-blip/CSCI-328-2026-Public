package library;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DailyLateFeePolicy implements LateFeePolicy {
    private final BigDecimal dailyRate;
    private final BigDecimal maximumFee;
    private final int gracePeriodDays;

    public DailyLateFeePolicy(
            BigDecimal dailyRate,
            BigDecimal maximumFee,
            int gracePeriodDays) {

        Objects.requireNonNull(dailyRate, "Daily rate is required");

        if (dailyRate.signum() < 0) {
            throw new IllegalArgumentException("Daily rate cannot be negative");
        }

        if (maximumFee != null && maximumFee.signum() < 0) {
            throw new IllegalArgumentException("Maximum fee cannot be negative");
        }

        if (gracePeriodDays < 0) {
            throw new IllegalArgumentException("Grace period cannot be negative");
        }

        this.dailyRate = dailyRate;
        this.maximumFee = maximumFee;
        this.gracePeriodDays = gracePeriodDays;
    }

    @Override
    public BigDecimal calculateFee(LocalDate dueDate, LocalDate returnDate) {
        Objects.requireNonNull(dueDate, "Due date is required");
        Objects.requireNonNull(returnDate, "Return date is required");

        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        long chargeableDays = Math.max(0, daysLate - gracePeriodDays);

        BigDecimal fee = dailyRate.multiply(
                BigDecimal.valueOf(chargeableDays)
        );

        if (maximumFee != null) {
            fee = fee.min(maximumFee);
        }

        return fee;
    }
}