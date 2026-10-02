package classes_and_objects.assigment_problems;

class Employee {

    String name;
    String role;
    double salary;

    Employee(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    Employee(String name, String role) {
        this(name, role, 0);
    }

    void printProfile() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class EmployeeProfileCreation {

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("Rahul", "Software Engineer", 60000);

        Employee employee2 =
                new Employee("Anitha", "Intern");

        employee1.printProfile();
        employee2.printProfile();
    }
}