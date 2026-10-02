package classes_and_objects.class_problems;

class College {

    static String collegeName = "SRM University";
    static int studentCount = 0;

    String studentName;

    College(String studentName) {
        this.studentName = studentName;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Students Created: " + studentCount);
    }
}

public class StudentCollegeInformationManagement {

    public static void main(String[] args) {

        College[] students = {
            new College("Rahul"),
            new College("Anitha"),
            new College("Karthik")
        };

        College.printCollegeInfo();
    }
}