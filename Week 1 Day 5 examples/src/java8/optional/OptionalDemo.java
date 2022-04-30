package java8.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        User u = new User();
        u.setUsername("April");
        u.setPassword("123");

        // handling NullPointerException exception
//        try {
//            int age = u.getAge();
//            System.out.println(age);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

        // using Optional
        Optional<Integer> possibleAge = Optional.ofNullable(u.getAge());
        // return the age if present, otherwise return a default age
        System.out.println(possibleAge.orElse(0));

    }
}
