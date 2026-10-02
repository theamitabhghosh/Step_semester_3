package inheritance.assigment_problems;

abstract class Customer {

    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateBill();
}

class StudentCustomer extends Customer {

    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateBill() {
        return amount - (amount * 0.10);
    }
}

class StaffCustomer extends Customer {

    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateBill() {
        return amount - (amount * 0.05);
    }
}

class GuestCustomer extends Customer {

    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateBill() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Customer[] customers = {
            new StudentCustomer(500),
            new StaffCustomer(500),
            new GuestCustomer(500)
        };

        double total = 0;

        for (Customer customer : customers) {

            double bill = customer.calculateBill();

            if (customer instanceof StudentCustomer) {
                System.out.printf("STUDENT: %.2f%n", bill);
            }
            else if (customer instanceof StaffCustomer) {
                System.out.printf("STAFF: %.2f%n", bill);
            }
            else if (customer instanceof GuestCustomer) {
                System.out.printf("GUEST: %.2f%n", bill);
            }

            total += bill;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}