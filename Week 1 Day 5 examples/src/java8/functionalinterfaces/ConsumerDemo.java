package java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        // consumer that prints an integer
        Consumer<Integer> printInteger = num -> System.out.println(num);
        printInteger.accept(42);

        // consumer that prints a list
        Consumer<List<Integer>> printList = list -> {
            list.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        printList.accept(numbers);

        // consumer that scales the elements of a list by 10
        Consumer<List<Integer>> scaleList = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, list.get(i) * 10);
        };

        scaleList.accept(numbers);
        printList.accept(numbers);

        // chain consumers
        scaleList.andThen(printList).accept(numbers);

    }
}
