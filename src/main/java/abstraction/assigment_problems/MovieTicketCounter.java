package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MovieTicket {
    protected int count;

    private static final double CONVENIENCE_FEE = 20.0;

    public MovieTicket(int count) {
        this.count = count;
    }

    public abstract double getTicketPrice();

    public double calculateAmount() {
        return count * (getTicketPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {

    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getTicketPrice() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {

    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getTicketPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {

    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getTicketPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<MovieTicket> bookings = new ArrayList<>();
        List<String> seatTypes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String seat = input[0];
            int count = Integer.parseInt(input[1]);

            MovieTicket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;

                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;

                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown seat type: " + seat
                    );
            }

            bookings.add(ticket);
            seatTypes.add(seat);
        }

        double total = 0.0;

        for (int i = 0; i < bookings.size(); i++) {
            double amount = bookings.get(i).calculateAmount();

            System.out.printf(
                "%s: %.2f%n",
                seatTypes.get(i),
                amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}