package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateShippingCharge();

    public double calculateInsurance() {
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + calculateInsurance();
    }
}

interface Insurable {
    double calculateInsurance();
}

class StandardParcel extends Parcel {

    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg);
    }
}

class ExpressParcel extends Parcel implements Insurable {

    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {

    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<Parcel> parcels = new ArrayList<>();
        List<String> types = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double weightKg = Double.parseDouble(input[1]);
            double declaredValue = Double.parseDouble(input[2]);

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weightKg, declaredValue);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weightKg, declaredValue);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weightKg, declaredValue);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown parcel type: " + type
                    );
            }

            parcels.add(parcel);
            types.add(type);
        }

        double grandTotal = 0.0;

        for (int i = 0; i < parcels.size(); i++) {
            Parcel parcel = parcels.get(i);

            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types.get(i),
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}