package inheritance.class_problems;

abstract class Transport {

    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {

    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {

    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {

        double baseFare = 1.50 + (0.20 * distance);

        return baseFare * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {

        Transport[] transports = {
            new Bus(50),
            new Train(50),
            new Metro(50, 1.5)
        };

        double total = 0;

        for (Transport transport : transports) {

            double fare = transport.calculateFare();

            if (transport instanceof Bus) {
                System.out.printf("BUS: %.2f%n", fare);
            }
            else if (transport instanceof Train) {
                System.out.printf("TRAIN: %.2f%n", fare);
            }
            else if (transport instanceof Metro) {
                System.out.printf("METRO: %.2f%n", fare);
            }

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}