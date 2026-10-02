package classes_and_objects.assigment_problems;

class HallTicket {

    String studentName;
    String exam;

    HallTicket(String studentName, String exam) {
        this.studentName = studentName;
        this.exam = exam;
    }

    void printTicket() {
        System.out.println("Student: " + studentName);
        System.out.println("Exam: " + exam);
    }
}

public class ExamHallTicketReferenceManagement {

    public static void main(String[] args) {

        HallTicket ticket1 =
                new HallTicket("Rahul", "Java Programming");

        HallTicket ticket2 = ticket1;

        HallTicket ticket3 =
                new HallTicket("Rahul", "Java Programming");

        System.out.println("Ticket 1:");
        ticket1.printTicket();

        System.out.println("\nTicket 2:");
        ticket2.printTicket();

        System.out.println("\nTicket 3:");
        ticket3.printTicket();

        System.out.println("\nticket1 == ticket2: " + (ticket1 == ticket2));
        System.out.println("ticket1 == ticket3: " + (ticket1 == ticket3));
    }
}