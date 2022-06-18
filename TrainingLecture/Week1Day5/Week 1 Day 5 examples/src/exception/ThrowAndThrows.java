package exception;

public class ThrowAndThrows {

    static void isPositive(int number) throws ArithmeticException {
        if (number < 0) {
            throw new ArithmeticException("Oops, this error should be positive");
        }
        else {
            System.out.println("Success! This number is positive");
        }
    }

    public static void main(String[] args) {
//        isPositive(-2);

        try {
            isPositive(-2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception is handled in main");
        }
    }
}
