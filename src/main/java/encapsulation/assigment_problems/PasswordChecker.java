package encapsulation.assigment_problems;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public String getStrength() {

        int length = password.length();

        if (length <= 4) {
            return "Weak";
        } else if (length <= 8) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        PasswordChecker checker = new PasswordChecker("hello123");

        System.out.println("Correct password: "
                + checker.checkPassword("hello123"));

        System.out.println("Wrong password: "
                + checker.checkPassword("hello"));

        System.out.println("Password strength: "
                + checker.getStrength());
    }
}