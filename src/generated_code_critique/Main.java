package library;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LateFeeCalculator calculator = new LateFeeCalculator();

        LocalDate dueDate = LocalDate.of(2026, 11, 1);
        LocalDate returnDate = LocalDate.of(2026, 11, 5);

        LibraryItem book = LibraryItemFactory.createBook("Java Basics");
        LibraryItem dvd = LibraryItemFactory.createDVD("Documentary");
        LibraryItem equipment =
                LibraryItemFactory.createEquipment("Camera");

        Loan bookLoan = new Loan(book, dueDate);
        Loan dvdLoan = new Loan(dvd, dueDate);
        Loan equipmentLoan = new Loan(equipment, dueDate);

        System.out.println("Book fee: $" +
                calculator.calculate(bookLoan, returnDate));

        System.out.println("DVD fee: $" +
                calculator.calculate(dvdLoan, returnDate));

        System.out.println("Equipment fee: $" +
                calculator.calculate(equipmentLoan, returnDate));
    }
}