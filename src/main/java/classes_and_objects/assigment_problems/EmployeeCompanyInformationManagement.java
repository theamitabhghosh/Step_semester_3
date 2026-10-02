package classes_and_objects.assigment_problems;

class Company {

    static String companyName = "Tech Solutions";
    static int employeeCount = 0;

    String employeeName;

    Company(String employeeName) {
        this.employeeName = employeeName;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees Created: " + employeeCount);
    }
}

public class EmployeeCompanyInformationManagement {

    public static void main(String[] args) {

        Company[] employees = {
            new Company("Rahul"),
            new Company("Anitha"),
            new Company("Karthik")
        };

        Company.printCompanyInfo();
    }
}