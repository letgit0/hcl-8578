package day5.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Day 5 - Generic methods and bounded types.
 */
public class GenericMethodDemo {

    // <T> before the return type declares a type parameter that only this method uses
    public static <T> void printAll(T[] items) {
        for (T item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // bounded type: T must implement Comparable<T>, so compareTo() can be used inside the method
    public static <T extends Comparable<T>> T findMax(T first, T second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }

    // wildcard with an upper bound: a list of Number or of any subclass of Number (Integer, Double, ...)
    public static double sum(List<? extends Number> numbers) {
        double total = 0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Integer[] numbers = {3, 1, 4};                  // Integer[], not int[]: T has to be a class
        String[] names = {"Asha", "Ravi", "Meera"};
        printAll(numbers);                              // T = Integer
        printAll(names);                                // T = String

        System.out.println(findMax(10, 25));            // 25     (T = Integer)
        System.out.println(findMax("apple", "mango"));  // mango  (T = String)
        System.out.println(findMax(2.5, 1.5));          // 2.5    (T = Double)
        // findMax(10, "ten");                          // does not compile: both arguments must be the same type T

        System.out.println(sum(Arrays.asList(1, 2, 3)));        // 6.0
        System.out.println(sum(Arrays.asList(1.5, 2.5)));       // 4.0
    }
}
