package encapsulation.class_problems;

public class LockerCode {

    private int code;
    private boolean codeSet;

    public LockerCode() {
        codeSet = false;
    }

    public void setCode(int newCode) {
        if (newCode >= 1000 && newCode <= 9999) {
            code = newCode;
            codeSet = true;
        }
    }

    public boolean isCodeSet() {
        return codeSet;
    }

    public static void main(String[] args) {

        LockerCode locker = new LockerCode();

        System.out.println("Code set: " + locker.isCodeSet());

        locker.setCode(123);

        System.out.println("Code set after invalid code: "
                + locker.isCodeSet());

        locker.setCode(1234);

        System.out.println("Code set after valid code: "
                + locker.isCodeSet());
    }
}