package library;

import java.math.BigDecimal;

public class LibraryItemFactory {

    public static LibraryItem createBook(String title) {
        return new LibraryItem(
                title,
                new DailyLateFeePolicy(
                        new BigDecimal("0.25"),
                        new BigDecimal("10.00"),
                        1
                )
        );
    }

    public static LibraryItem createDVD(String title) {
        return new LibraryItem(
                title,
                new DailyLateFeePolicy(
                        new BigDecimal("1.00"),
                        new BigDecimal("20.00"),
                        0
                )
        );
    }

    public static LibraryItem createEquipment(String title) {
        return new LibraryItem(
                title,
                new DailyLateFeePolicy(
                        new BigDecimal("5.00"),
                        null,
                        0
                )
        );
    }
}