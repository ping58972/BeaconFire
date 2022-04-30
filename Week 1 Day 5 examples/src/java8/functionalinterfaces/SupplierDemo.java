package java8.functionalinterfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        // supplier that returns a random integer in the range [1, 10]
        Supplier<Integer> supplyRandomInt = () -> (int)(Math.random() * 10 + 1);
        System.out.println(supplyRandomInt.get());

        // supplier that returns the current local date
        Supplier<LocalDate> supplyLocalDate = () -> java.time.LocalDate.now();
        System.out.println(supplyLocalDate.get());

    }
}
