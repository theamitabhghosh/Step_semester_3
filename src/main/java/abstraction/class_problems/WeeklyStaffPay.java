package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<Staff> staffMembers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            String name = input[1];

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    double salary = Double.parseDouble(input[2]);
                    staff = new FullTimeStaff(name, salary);
                    break;

                case "HOURLY":
                    double hours = Double.parseDouble(input[2]);
                    double rate = Double.parseDouble(input[3]);
                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = Double.parseDouble(input[2]);
                    staff = new InternStaff(name, stipend);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown staff type: " + type
                    );
            }

            staffMembers.add(staff);
        }

        double totalPayroll = 0.0;

        for (Staff staff : staffMembers) {
            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", staff.getName(), pay);

            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}