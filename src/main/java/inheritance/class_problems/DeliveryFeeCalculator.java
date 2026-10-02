package inheritance.class_problems;

abstract class Delivery {

    protected double distance;

    public Delivery(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {

    public StandardDelivery(double distance) {
        super(distance);
    }

    @Override
    public double calculateFee() {
        return 50 + (distance * 5);
    }
}

class ExpressDelivery extends Delivery {

    public ExpressDelivery(double distance) {
        super(distance);
    }

    @Override
    public double calculateFee() {
        return 100 + (distance * 8);
    }
}

class InternationalDelivery extends Delivery {

    private double customsFee;

    public InternationalDelivery(double distance, double customsFee) {
        super(distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 200 + (distance * 12) + customsFee;
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Delivery[] deliveries = {
            new StandardDelivery(10),
            new ExpressDelivery(10),
            new InternationalDelivery(10, 500)
        };

        double total = 0;

        for (Delivery delivery : deliveries) {

            double fee = delivery.calculateFee();

            if (delivery instanceof StandardDelivery) {
                System.out.printf("STANDARD: %.2f%n", fee);
            }
            else if (delivery instanceof ExpressDelivery) {
                System.out.printf("EXPRESS: %.2f%n", fee);
            }
            else if (delivery instanceof InternationalDelivery) {
                System.out.printf("INTERNATIONAL: %.2f%n", fee);
            }

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}