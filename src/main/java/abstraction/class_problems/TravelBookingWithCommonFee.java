package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;

    private static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {

    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {

    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {

    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class TravelBookingWithCommonFee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<TravelBooking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String mode = input[0];
            double distanceKm = Double.parseDouble(input[1]);

            TravelBooking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distanceKm);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distanceKm);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distanceKm);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown travel mode: " + mode
                    );
            }

            bookings.add(booking);
            modes.add(mode);
        }

        for (int i = 0; i < bookings.size(); i++) {
            double totalFare = bookings.get(i).calculateTotalFare();

            System.out.printf(
                "%s: %.2f%n",
                modes.get(i),
                totalFare
            );
        }

        sc.close();
    }
}