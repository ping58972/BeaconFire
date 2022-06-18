/*
* Author: Ping Danddank.
* email: ndanddank@gmail.com
* Question 1: Change Java PriorityQueue to a maximum PriorityQueue.
* */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class MaxPriorityQueue {
    public static void main(String[] args) {
        maxPQ_integer();
        maxPQ_double();
        mapPQ_string();
        maxPQ_BigInteger();
        maxPQ_BigDecimal();
    }

    // change Priority Queue of BigDecimal to descending order.
    private static void maxPQ_BigDecimal() {
        Queue<BigDecimal> maxPQ_bigInt = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(2));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(3));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(4));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(5));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(6));
        maxPQ_bigInt.add(BigDecimal.valueOf(Double.MAX_VALUE).pow(7));
        while(!maxPQ_bigInt.isEmpty())
            System.out.println(maxPQ_bigInt.poll());
    }
    // change Priority Queue of BigInteger to descending order.
    private static void maxPQ_BigInteger() {
        Queue<BigInteger> maxPQ_bigInt = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(2));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(3));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(4));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(5));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(6));
        maxPQ_bigInt.add(BigInteger.valueOf(Integer.MAX_VALUE).pow(7));
        while(!maxPQ_bigInt.isEmpty())
            System.out.println(maxPQ_bigInt.poll());
    }
    // change Priority Queue of String to descending order.
    private static void mapPQ_string() {
        Queue<String> maxPQ_int = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        maxPQ_int.add("3.0");
        maxPQ_int.add("1.0");
        maxPQ_int.add("16.1");
        maxPQ_int.add("2.6");
        maxPQ_int.add("3.6");
        maxPQ_int.add("9.5");
        while(!maxPQ_int.isEmpty())
            System.out.println(maxPQ_int.poll());
    }
    // change Priority Queue of Double to descending order.
    private static void maxPQ_double() {
        Queue<Double> maxPQ_int = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        maxPQ_int.add(3.0);
        maxPQ_int.add(1.0);
        maxPQ_int.add(6.1);
        maxPQ_int.add(2.6);
        maxPQ_int.add(3.6);
        maxPQ_int.add(9.5);
        while(!maxPQ_int.isEmpty())
            System.out.println(maxPQ_int.poll());
    }
    // change Priority Queue of Integer to descending order.
    public static void maxPQ_integer(){
        Queue<Integer> maxPQ_int = new PriorityQueue<>((i1, i2) -> i2 - i1);
        maxPQ_int.add(3);
        maxPQ_int.add(1);
        maxPQ_int.add(6);
        maxPQ_int.add(2);
        maxPQ_int.add(3);
        maxPQ_int.add(9);
        while(!maxPQ_int.isEmpty())
            System.out.println(maxPQ_int.poll());

    }

}