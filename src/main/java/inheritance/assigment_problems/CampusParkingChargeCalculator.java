package inheritance.assigment_problems;

abstract class Vehicle {

    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {

    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {

    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {

        if (hours <= 1) {
            return 30;
        }

        return 30 + ((hours - 1) * 20);
    }
}

class Truck extends Vehicle {

    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Bike(3),
            new Car(3),
            new Truck(1)
        };

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            if (vehicle instanceof Bike) {
                System.out.printf("BIKE: %.2f%n", charge);
            }
            else if (vehicle instanceof Car) {
                System.out.printf("CAR: %.2f%n", charge);
            }
            else if (vehicle instanceof Truck) {
                System.out.printf("TRUCK: %.2f%n", charge);
            }

            total += charge;
        }

        System.out.printf("Total Charge: %.2f%n", total);
    }
}