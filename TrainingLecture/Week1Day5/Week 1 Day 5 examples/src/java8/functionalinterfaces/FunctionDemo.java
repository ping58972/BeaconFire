package java8.functionalinterfaces;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        // function example
        Function<Integer, String> greet = number -> "Hello, Player #" + number;
        System.out.println(greet.apply(0));

        // add 1 to the input of greet before greet is applied
        greet = greet.compose(number -> number + 1);
        System.out.println(greet.apply(0));

        // add "! :D" to the output of greet after greet is applied
        greet = greet.andThen(str -> str + "! :D");
        System.out.println(greet.apply(0));

    }
}
