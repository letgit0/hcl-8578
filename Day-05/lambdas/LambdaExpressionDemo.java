package day5.lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Day 5 - Lambda expressions: a short way to write the implementation of a functional interface.
 *
 *   (parameters) -> expression
 *   (parameters) -> { statements; }
 */
public class LambdaExpressionDemo {

    public static void main(String[] args) {
        syntax();
        withCollections();
        capturingVariables();
    }

    private static void syntax() {
        // no parameters
        Runnable greet = () -> System.out.println("Hello from a lambda");
        greet.run();

        // one parameter: the parentheses are optional and the type is inferred
        Function<Integer, Integer> square = n -> n * n;
        System.out.println("square(6): " + square.apply(6));                    // 36

        // two parameters, with the types written out (optional)
        BiFunction<Integer, Integer, Integer> add = (Integer a, Integer b) -> a + b;
        System.out.println("add(4, 6): " + add.apply(4, 6));                    // 10

        // block body: braces, statements and an explicit return
        BiFunction<Integer, Integer, Integer> max = (a, b) -> {
            if (a > b) {
                return a;
            }
            return b;
        };
        System.out.println("max(4, 6): " + max.apply(4, 6));                    // 6
    }

    // many collection methods take a functional interface, so a lambda fits right in
    private static void withCollections() {
        List<String> names = new ArrayList<>();
        names.add("Meera");
        names.add("Asha");
        names.add("Ravi");
        names.add("John");

        names.forEach(name -> System.out.println("Hello, " + name));    // forEach takes a Consumer
        names.forEach(System.out::println);                              // method reference: the lambda only calls one method

        names.removeIf(name -> name.startsWith("J"));                    // removeIf takes a Predicate
        System.out.println(names);                                       // [Meera, Asha, Ravi]

        names.replaceAll(name -> name.toUpperCase());                    // replaceAll takes a UnaryOperator
        System.out.println(names);                                       // [MEERA, ASHA, RAVI]

        names.sort((first, second) -> first.compareTo(second));          // sort takes a Comparator
        System.out.println(names);                                       // [ASHA, MEERA, RAVI]

        Map<Integer, String> students = new HashMap<>();
        students.put(101, "Asha");
        students.put(102, "Ravi");
        students.forEach((rollNo, name) -> System.out.println(rollNo + " -> " + name));    // Map.forEach takes a BiConsumer
    }

    // a lambda can use local variables of the surrounding method, but only if they never change (effectively final)
    private static void capturingVariables() {
        int bonus = 5;
        Function<Integer, Integer> addBonus = marks -> marks + bonus;
        System.out.println("80 + bonus: " + addBonus.apply(80));                  // 85
        // bonus++;                // adding this line would not compile: bonus must be effectively final
    }
}
