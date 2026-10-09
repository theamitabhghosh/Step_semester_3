package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Student {
    protected String name;

    private static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuitionFee();

    public double calculateAdditionalFee() {
        return 0.0;
    }

    public boolean usesCollegeBus() {
        return false;
    }

    public double calculateTotalFee() {
        double total = calculateTuitionFee() + calculateAdditionalFee();

        if (usesCollegeBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {

    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionFee() {
        return 40000.0;
    }

    @Override
    public boolean usesCollegeBus() {
        return true;
    }
}

class Hosteller extends Student {

    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionFee() {
        return 40000.0;
    }

    @Override
    public double calculateAdditionalFee() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student {

    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionFee() {
        return 20000.0;
    }

    @Override
    public boolean usesCollegeBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            String name = input[1];

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Unknown student type: " + type
                    );
            }

            students.add(student);
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            double fee = student.calculateTotalFee();

            System.out.printf(
                "%s: %.2f%n",
                student.getName(),
                fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}