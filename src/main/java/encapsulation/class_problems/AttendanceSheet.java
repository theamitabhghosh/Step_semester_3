package encapsulation.class_problems;

import java.util.Arrays;

public class AttendanceSheet {

    private String[] studentNames;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        studentNames = new String[capacity];
        presentCount = 0;
    }

    public void addStudent(String name) {

        if (presentCount >= studentNames.length) {
            return;
        }

        for (int i = 0; i < presentCount; i++) {
            if (studentNames[i].equals(name)) {
                return;
            }
        }

        studentNames[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public String[] getStudentNames() {
        return Arrays.copyOf(studentNames, presentCount);
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(5);

        sheet.addStudent("Rahul");
        sheet.addStudent("Anitha");
        sheet.addStudent("Rahul");
        sheet.addStudent("Karthik");

        System.out.println("Present Count: " + sheet.getPresentCount());

        String[] names = sheet.getStudentNames();

        System.out.println("Students: " + Arrays.toString(names));
    }
}