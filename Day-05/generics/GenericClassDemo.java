package day5.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Day 5 - Using generic classes. Generics give type safety at compile time and remove the need for casts.
 */
public class GenericClassDemo {

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(50);            // T = Integer (50 is autoboxed)
        Box<String> textBox = new Box<>("Java");        // T = String
        int number = intBox.getValue();                 // no cast needed
        String text = textBox.getValue();
        System.out.println(intBox + " " + textBox);
        System.out.println(number + 1);                 // 51
        System.out.println(text.toUpperCase());         // JAVA
        // Box<int> wrong = new Box<>(5);               // does not compile: a type argument must be a class, so use Box<Integer>

        // two type parameters
        Pair<String, Integer> marks = new Pair<>("Asha", 88);
        Pair<Integer, String> student = new Pair<>(101, "Ravi");
        System.out.println(marks + " " + student);
        System.out.println(marks.getKey() + " scored " + marks.getValue());

        // the collections you already use are generic too: List<E>, Map<K, V>
        List<String> names = new ArrayList<>();
        names.add("Asha");
        // names.add(10);                               // does not compile: List<String> only accepts String
        String firstName = names.get(0);                // no cast needed
        System.out.println(firstName);

        withoutGenerics();
    }

    // Before generics a collection held plain Objects: anything went in and mistakes showed up only at run time.
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void withoutGenerics() {
        List raw = new ArrayList();                     // raw type: no <...>
        raw.add("Asha");
        raw.add(10);                                    // compiles, even though a list of names was intended
        try {
            String second = (String) raw.get(1);        // the cast is needed and fails while running
            System.out.println(second);
        } catch (ClassCastException e) {
            System.out.println("Raw list: ClassCastException at run time");
        }
    }
}
