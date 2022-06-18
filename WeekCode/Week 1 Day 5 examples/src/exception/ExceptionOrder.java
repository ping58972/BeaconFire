package exception;

public class ExceptionOrder {

    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[99]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops, array index out of bounds");

        } catch (Exception e) {
            System.out.println("Oops, something went wrong");
        }
    }
}
