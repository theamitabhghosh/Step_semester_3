package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRating();

    public boolean supportsSaverMode() {
        return false;
    }

    public double calculateUnits(boolean saverMode) {
        double units = (getPowerRating() * hours) / 1000.0;

        if (saverMode) {
            units *= 0.75;
        }

        return units;
    }

    public double calculateCost(boolean saverMode) {
        return calculateUnits(saverMode) * 8.0;
    }
}

class Fridge extends Appliance {

    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance {

    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class Television extends Appliance {

    public Television(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance {

    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class ApplianceUsage {
    private Appliance appliance;
    private String name;
    private boolean saverMode;

    public ApplianceUsage(
        Appliance appliance,
        String name,
        boolean saverMode
    ) {
        this.appliance = appliance;
        this.name = name;
        this.saverMode = saverMode;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public String getName() {
        return name;
    }

    public boolean isSaverMode() {
        return saverMode;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<ApplianceUsage> usages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String name = input[0];
            double hours = Double.parseDouble(input[1]);

            boolean saverMode =
                input.length == 3 && input[2].equals("SAVER");

            Appliance appliance;

            switch (name) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new Television(hours);
                    break;

                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown appliance: " + name
                    );
            }

            usages.add(
                new ApplianceUsage(appliance, name, saverMode)
            );
        }

        double totalCost = 0.0;

        for (ApplianceUsage usage : usages) {
            Appliance appliance = usage.getAppliance();
            String name = usage.getName();
            boolean saverMode = usage.isSaverMode();

            if (saverMode && !appliance.supportsSaverMode()) {
                System.out.printf(
                    "%s: saver mode not supported%n",
                    name
                );
                continue;
            }

            double units = appliance.calculateUnits(saverMode);
            double cost = appliance.calculateCost(saverMode);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                name,
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}