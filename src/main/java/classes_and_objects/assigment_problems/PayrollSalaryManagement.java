package classes_and_objects.assigment_problems;

class Payroll {

    private double baseSalary;
    private double bonus;
    private double tax;

    Payroll(double baseSalary, double tax) {

        if (baseSalary < 0) {
            System.out.println("Warning: Negative salary. Starting at 0.");
            this.baseSalary = 0;
        } else {
            this.baseSalary = baseSalary;
        }

        if (tax < 0) {
            System.out.println("Warning: Negative tax. Starting at 0.");
            this.tax = 0;
        } else {
            this.tax = tax;
        }

        this.bonus = 0;
    }

    public void giveBonus(double amount) {
        if (amount > 0) {
            bonus += amount;
        }
    }

    public double getNetSalary() {
        return baseSalary + bonus - tax;
    }
}

public class PayrollSalaryManagement {

    public static void main(String[] args) {

        Payroll employee1 = new Payroll(50000, 5000);

        employee1.giveBonus(10000);

        System.out.println("Net Salary: " + employee1.getNetSalary());
    }
}