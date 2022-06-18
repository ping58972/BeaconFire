package exception;

public class FinallyExample {

    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[99]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops, array index out of bounds");

        } finally {
            System.out.println("finally block executes");
        }
    }
}
