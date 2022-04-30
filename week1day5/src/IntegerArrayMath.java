/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 3:  IntegerArrayMath class with integer division method
 * */

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerArrayMath {
    public static void main(String[] args) {
        int start = 0, end = 20;
        // create two list of Integer to process.
        List<Integer> numbers = IntStream.rangeClosed(start+2, end-4).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> denoms = IntStream.rangeClosed(start, end +1).boxed().collect(Collectors.toList());
        Collections.shuffle(denoms);
        // a. Loops thru instance field array and attempts to divide each value of
        //number array by the corresponding value of denom instance field array.
        //such as number[0]/denom[0] and number[1]/denom[1],etc
        IntStream.range(start, end).forEach(i -> {
            try{
                if(numbers.get(i)%denoms.get(i)!= 0) {
                    // c. If the result of the division is not an integer, then throw and handle
                    // a NonIntResultException and continue processing the result of the
                    // number array elements.
                    throw new NonIntResultException(numbers.get(i), numbers.get(i));
                } else {
                    //b. If the result of the division is an integer, then print out a message
                    //indicating the result of the division such as 8/4 is 2.
                    System.out.println("The result of the division: " +
                            numbers.get(i) + " / " + denoms.get(i) + " is " + (numbers.get(i) / denoms.get(i)));
                }
            } catch(NonIntResultException ne){
                System.out.println( ne.getMessage());
            } catch (ArithmeticException a){
                // exception handling also handle any attempt to
                // divide by zero (arithmetic exception)
                System.out.println("Exception of Divide " + a.getMessage());
            } catch (IndexOutOfBoundsException ie){
                // handle Index out of range
                // divide by zero (arithmetic exception)
                System.out.println("Index out of range: " + ie.getMessage());
            } catch (Exception e){
                // handle any other exception.
                System.out.println(e.getMessage());
            }
        });


    }
}
