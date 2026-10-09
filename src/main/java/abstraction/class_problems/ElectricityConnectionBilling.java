package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {

    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }

        return (100 * 5.0) + ((units - 100) * 7.0);
    }
}

class ShopConnection extends ElectricityConnection {

    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {

    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<ElectricityConnection> connections = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            int units = Integer.parseInt(input[1]);

            ElectricityConnection connection;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;

                case "SHOP":
                    connection = new ShopConnection(units);
                    break;

                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown connection type: " + type
                    );
            }

            connections.add(connection);
            types.add(type);
        }

        double total = 0.0;

        for (int i = 0; i < connections.size(); i++) {
            double bill = connections.get(i).calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                types.get(i),
                bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}