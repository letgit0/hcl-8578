package day5.wrappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Day 5 - Autoboxing and unboxing: the compiler converts between a primitive and its wrapper automatically.
 *
 *   autoboxing: int -> Integer        unboxing: Integer -> int
 */
public class AutoboxingDemo {

    // takes a wrapper, returns a primitive
    static int doubleIt(Integer number) {
        return number * 2;                  // number is unboxed for the multiplication
    }

    public static void main(String[] args) {
        // autoboxing: the compiler turns this into Integer.valueOf(10)
        Integer boxed = 10;
        // unboxing: the compiler turns this into boxed.intValue()
        int unboxed = boxed;
        System.out.println("boxed = " + boxed + ", unboxed = " + unboxed);

        // arithmetic: unbox, calculate, box the result again
        Integer total = boxed + 5;
        total++;
        System.out.println("total = " + total);                          // 16

        // method calls box and unbox too
        System.out.println("doubleIt(21) = " + doubleIt(21));            // 21 is boxed, the int result 42 comes back

        // collections hold objects only, so the primitives are boxed for you
        List<Integer> marks = new ArrayList<>();
        marks.add(80);                      // autoboxing
        marks.add(65);
        marks.add(92);
        int first = marks.get(0);           // unboxing
        int sum = 0;
        for (int mark : marks) {            // unboxing on every pass
            sum += mark;
        }
        System.out.println("marks = " + marks + ", first = " + first + ", sum = " + sum);

        // boxing only gives you the matching wrapper
        double widened = 10;                // OK: int is widened to double
        // Double boxedDouble = 10;         // does not compile: an int can only be boxed to Integer (write 10.0)
        System.out.println("widened = " + widened);

        pitfalls();
    }

    private static void pitfalls() {
        System.out.println();
        System.out.println("Pitfalls");

        // 1. == on wrappers compares object references, not values
        Integer a = 100;
        Integer b = 100;
        System.out.println("100 == 100: " + (a == b));                   // true: Integer reuses cached objects for -128 to 127
        Integer c = 1000;
        Integer d = 1000;
        System.out.println("1000 == 1000: " + (c == d));                 // false: two different objects
        System.out.println("1000 equals 1000: " + c.equals(d));          // true: always compare wrappers with equals()

        // 2. unboxing null throws NullPointerException
        Integer missing = null;
        try {
            int value = missing;
            System.out.println(value);
        } catch (NullPointerException e) {
            System.out.println("Unboxing null -> NullPointerException");
        }

        // 3. List<Integer>: remove(int index) and remove(Object value) are different methods
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.remove(1);                          // int: removes the element at INDEX 1 (the 20)
        System.out.println(numbers);                // [10, 30]
        numbers.remove(Integer.valueOf(30));        // Integer: removes the VALUE 30
        System.out.println(numbers);                // [10]
    }
}
