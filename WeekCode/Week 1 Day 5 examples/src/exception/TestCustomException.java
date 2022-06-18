package exception;

public class TestCustomException {

    public static void main(String[] args) {
        try {
            throw new MyCustomException("Oops, something went wrong");
        } catch (MyCustomException e) {
            e.printStackTrace();
        }
    }
}
