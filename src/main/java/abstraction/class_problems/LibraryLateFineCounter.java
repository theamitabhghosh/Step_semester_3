package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class Book extends LibraryItem {

    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {

    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            String title = input[1];
            int daysLate = Integer.parseInt(input[2]);

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;

                case "DVD":
                    item = new DVD(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown library item type: " + type
                    );
            }

            items.add(item);
        }

        double totalFines = 0.0;

        for (LibraryItem item : items) {
            double fine = item.calculateFine();

            System.out.printf(
                "%s: %.2f%n",
                item.getTitle(),
                fine
            );

            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        sc.close();
    }
}