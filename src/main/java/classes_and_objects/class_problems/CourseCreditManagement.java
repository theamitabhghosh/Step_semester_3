package classes_and_objects.class_problems;

class Course {

    String code;
    int credits;

    Course() {
        this("NA", 0);
    }

    Course(String code) {
        this(code, 3);
    }

    Course(String code, int credits) {
        this.code = code;
        this.credits = credits;
    }

    void printCourse() {
        System.out.println("Course: " + code + ", Credits: " + credits);
    }
}

public class CourseCreditManagement {

    public static void main(String[] args) {

        Course course1 = new Course();
        Course course2 = new Course("CSE101");
        Course course3 = new Course("CSE205", 4);

        course1.printCourse();
        course2.printCourse();
        course3.printCourse();
    }
}