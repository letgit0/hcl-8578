package day5.functionalinterfaces;

/**
 * Day 5 - Functional interface: an interface with exactly ONE abstract method.
 *
 * With only one method to implement, a lambda expression can be the implementation.
 * @FunctionalInterface is optional, but with it the compiler rejects the interface as soon as a second
 * abstract method is added.
 *
 * Day 1's Calculator class had one method per operation; here the operation itself is passed in.
 */
@FunctionalInterface
public interface Calculator {

    int calculate(int a, int b);            // the single abstract method

    // default (and static) methods are allowed: they have a body, so they are not abstract
    default void show(int a, int b) {
        System.out.println("Result for " + a + " and " + b + ": " + calculate(a, b));
    }
}
