package day5.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Day 5 - Ready-made functional interfaces from java.util.function, so you rarely have to write your own.
 *
 *   Predicate<T>          T -> boolean         test()
 *   Function<T, R>        T -> R               apply()
 *   Consumer<T>           T -> nothing         accept()
 *   Supplier<T>           nothing -> T         get()
 *   BiFunction<T, U, R>   (T, U) -> R          apply()
 *
 * Also: UnaryOperator<T> is Function<T, T> and BinaryOperator<T> is BiFunction<T, T, T>.
 * The type arguments must be classes, so it is Predicate<Integer>, not Predicate<int>.
 */
public class BuiltInFunctionalInterfacesDemo {

    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("isEven(10): " + isEven.test(10));                   // true
        System.out.println("isEven(7): " + isEven.test(7));                     // false

        Predicate<Integer> isPositive = number -> number > 0;
        System.out.println("even and positive (-4): " + isEven.and(isPositive).test(-4));    // false
        System.out.println("not even (7): " + isEven.negate().test(7));                       // true

        Function<String, Integer> length = text -> text.length();
        System.out.println("length of Java: " + length.apply("Java"));          // 4
        Function<Integer, Integer> square = number -> number * number;
        System.out.println("length, then square: " + length.andThen(square).apply("Java"));   // 16

        Consumer<String> greeter = name -> System.out.println("Hello, " + name);
        greeter.accept("Asha");

        Supplier<String> course = () -> "Core Java";
        System.out.println("Course: " + course.get());

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("add(4, 6): " + add.apply(4, 6));                    // 10
    }
}
