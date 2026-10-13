package day5.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Day 5 - Comparable on its own: what compareTo() returns and how Collections.sort(list) uses it.
 * Next: ComparatorDemo puts Comparable and Comparator side by side.
 */
public class ComparableDemo {

    public static void main(String[] args) {
        Student asha = new Student(101, "Asha", 20, 78);
        Student ravi = new Student(102, "Ravi", 19, 85);
        Student meera = new Student(103, "Meera", 20, 65);

        // compareTo() returns a number: negative = this one first, 0 = tie, positive = this one later
        System.out.println("ravi.compareTo(asha):  " + ravi.compareTo(asha));       // negative: Ravi (19) is younger than Asha (20)
        System.out.println("asha.compareTo(ravi):  " + asha.compareTo(ravi));       // positive
        System.out.println("asha.compareTo(asha):  " + asha.compareTo(asha));       // 0: identical age and marks
        System.out.println("meera.compareTo(asha): " + meera.compareTo(asha));      // negative: same age, fewer marks
        System.out.println();

        // Collections.sort(list) calls compareTo() for you. It only works for classes that implement Comparable.
        List<Student> students = new ArrayList<>();
        students.add(asha);
        students.add(ravi);
        students.add(meera);
        Collections.sort(students);
        System.out.println("Sorted students (age, then marks):");
        for (Student student : students) {
            System.out.println("  " + student);
        }
        System.out.println();

        // String and the wrapper classes already implement Comparable, so they sort without any extra code
        List<String> names = new ArrayList<>(Arrays.asList("Meera", "Asha", "Ravi"));
        Collections.sort(names);
        System.out.println(names);                  // [Asha, Meera, Ravi]
        List<Integer> marks = new ArrayList<>(Arrays.asList(78, 65, 85));
        Collections.sort(marks);
        System.out.println(marks);                  // [65, 78, 85]
    }
}
