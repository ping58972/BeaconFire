/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 2: NonIntResultException which is
generated when the result of dividing two integer values produces a result
with a fractional component [i.e the result is not an integer]
 * */
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class NonIntResultException extends Exception{
    // i. A constructor with parameter that represent the two integer values
    public NonIntResultException(int a, int b){
        //Generates an appropriate message, for example if the two integers
        //are 7 and 2, the resulting exception message would be: 7 divided
        //by 2 is not an integer
        super("The result of "+ a+" divided by "+ b + " is not an integer");
    }
    // Testing
    public static void main(String[] args) {

            BiConsumer<Integer, Integer> tester = (a, b) -> {
                try {
                    if(a%b != 0)
                        throw new NonIntResultException(a,b);
                    else
                        System.out.println("The result of "+ a+" divided by "+ b + " is an integer");
                } catch (NonIntResultException e) {
                    System.out.println(e.getMessage());
                }
            };
            tester.accept(7, 2);

    }
}
