package classes_and_objects.class_problems;

class IDCard {

    String cardNumber;
    String studentName;

    IDCard(String cardNumber, String studentName) {
        this.cardNumber = cardNumber;
        this.studentName = studentName;
    }

    void printCard() {
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Student Name: " + studentName);
    }
}

public class LibraryIDCardManagement {

    public static void main(String[] args) {

        IDCard card1 = new IDCard("LIB101", "Rahul");

        IDCard card2 = card1;

        IDCard card3 = new IDCard("LIB101", "Rahul");

        System.out.println("Card 1:");
        card1.printCard();

        System.out.println("\nCard 2:");
        card2.printCard();

        System.out.println("\nCard 3:");
        card3.printCard();

        System.out.println("\ncard1 == card2: " + (card1 == card2));
        System.out.println("card1 == card3: " + (card1 == card3));
    }
}