package inheritance.class_problems;

abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAmount();
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAmount() {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };

        double total = 0;

        for (Payment payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            if (payment instanceof CardPayment) {
                System.out.printf("CARD: %.2f%n", adjustedAmount);
            }
            else if (payment instanceof WalletPayment) {
                System.out.printf("WALLET: %.2f%n", adjustedAmount);
            }
            else if (payment instanceof BankTransferPayment) {
                System.out.printf("BANKTRANSFER: %.2f%n", adjustedAmount);
            }

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}