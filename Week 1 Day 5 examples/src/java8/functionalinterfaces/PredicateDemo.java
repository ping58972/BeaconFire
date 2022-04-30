package java8.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> isAgeValid = age -> (age >= 0);
        Predicate<Integer> isAdult = age -> (age >= 18);

        System.out.println("isAgeValid: " + isAgeValid.test(2));
        System.out.println("isAgeValid: " + isAgeValid.test(-1));
        System.out.println("isAgeValid AND isAdult: " + isAgeValid.and(isAdult).test(42));
        System.out.println("isAgeValid OR isAdult: " + isAgeValid.or(isAdult).test(42));
        System.out.println("isAgeValid OR (NOT isAdult): " +
                isAgeValid.or(isAdult.negate()).test(10));

    }
}
