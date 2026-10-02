package inheritance.assigment_problems;

abstract class Room {

    protected double units;

    public Room(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {

    public SingleRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {

    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom extends Room {

    public ACRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Room[] rooms = {
            new SingleRoom(100),
            new SharedRoom(120, 2),
            new ACRoom(100)
        };

        double total = 0;

        for (Room room : rooms) {

            double bill = room.calculateBill();

            if (room instanceof SingleRoom) {
                System.out.printf("SINGLE: %.2f%n", bill);
            }
            else if (room instanceof SharedRoom) {
                System.out.printf("SHARED: %.2f%n", bill);
            }
            else if (room instanceof ACRoom) {
                System.out.printf("AC: %.2f%n", bill);
            }

            total += bill;
        }

        System.out.printf("Total Bill: %.2f%n", total);
    }
}