package inheritance.assigment_problems;

abstract class Employee {

    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {

    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Employee[] employees = {
            new FullTimeEmployee("Amit", 50000),
            new PartTimeEmployee("Rahul", 30000),
            new Intern("Priya", 15000)
        };

        double totalBonus = 0;

        for (Employee employee : employees) {

            double bonus = employee.calculateBonus();

            if (employee instanceof FullTimeEmployee) {
                System.out.printf("FULLTIME: %.2f%n", bonus);
            }
            else if (employee instanceof PartTimeEmployee) {
                System.out.printf("PARTTIME: %.2f%n", bonus);
            }
            else if (employee instanceof Intern) {
                System.out.printf("INTERN: %.2f%n", bonus);
            }

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }
}