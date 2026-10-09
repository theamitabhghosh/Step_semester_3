package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Cab {
    protected double distanceKm;

    public Cab(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double getRatePerKm();

    public boolean supportsNightService() {
        return false;
    }

    public double calculateFare(boolean isNight) {
        double fare = distanceKm * getRatePerKm();

        // Apply the minimum fare first.
        fare = Math.max(fare, 100.0);

        // Apply the night surcharge after the minimum fare.
        if (isNight) {
            fare *= 1.20;
        }

        return fare;
    }
}

class MiniCab extends Cab {

    public MiniCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab {

    public SedanCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab {

    public SUVCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class CabTrip {
    private Cab cab;
    private String type;
    private boolean isNight;

    public CabTrip(Cab cab, String type, boolean isNight) {
        this.cab = cab;
        this.type = type;
        this.isNight = isNight;
    }

    public Cab getCab() {
        return cab;
    }

    public String getType() {
        return type;
    }

    public boolean isNight() {
        return isNight;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<CabTrip> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double distance = Double.parseDouble(input[1]);
            String time = input[2];

            boolean isNight = time.equals("NIGHT");

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(distance);
                    break;

                case "SEDAN":
                    cab = new SedanCab(distance);
                    break;

                case "SUV":
                    cab = new SUVCab(distance);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown cab type: " + type
                    );
            }

            trips.add(new CabTrip(cab, type, isNight));
        }

        double total = 0.0;

        for (CabTrip trip : trips) {
            Cab cab = trip.getCab();

            if (trip.isNight() && !cab.supportsNightService()) {
                System.out.printf(
                    "%s: night service not available%n",
                    trip.getType()
                );
                continue;
            }

            double fare = cab.calculateFare(trip.isNight());

            System.out.printf(
                "%s: %.2f%n",
                trip.getType(),
                fare
            );

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}