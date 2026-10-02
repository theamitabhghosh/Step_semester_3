package inheritance.class_problems;

import java.time.LocalDate;

abstract class LibraryItem {

    protected String itemId;

    public LibraryItem(String itemId) {
        this.itemId = itemId;
    }

    public abstract int getBorrowDays();

    public LocalDate calculateDueDate(LocalDate issueDate) {
        return issueDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {

    public Book(String itemId) {
        super(itemId);
    }

    @Override
    public int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    public DVD(String itemId) {
        super(itemId);
    }

    @Override
    public int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String itemId) {
        super(itemId);
    }

    @Override
    public int getBorrowDays() {
        return 3;
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {

        LocalDate issueDate = LocalDate.of(2023, 10, 26);

        LibraryItem[] items = {
            new Book("B001"),
            new DVD("D001"),
            new Magazine("M001")
        };

        for (LibraryItem item : items) {

            LocalDate dueDate = item.calculateDueDate(issueDate);

            if (item instanceof Book) {
                System.out.println("BOOK: " + dueDate);
            }
            else if (item instanceof DVD) {
                System.out.println("DVD: " + dueDate);
            }
            else if (item instanceof Magazine) {
                System.out.println("MAGAZINE: " + dueDate);
            }
        }
    }
}