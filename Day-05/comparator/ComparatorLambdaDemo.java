package day5.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Day 5 - Comparator with lambda expressions.
 *
 * Comparator has only one abstract method (compare), so it is a functional interface:
 * a lambda can replace the whole class or anonymous class from ComparatorDemo.
 */
public class ComparatorLambdaDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Asha", 20, 78));
        students.add(new Student(102, "Ravi", 19, 85));
        students.add(new Student(103, "Meera", 20, 65));
        students.add(new Student(104, "John", 21, 90));
        students.add(new Student(105, "Kiran", 19, 70));

        // 1. lambda: "(first, second) -> ..." is the body of compare()
        Collections.sort(students, (first, second) -> first.getName().compareTo(second.getName()));
        print("Lambda - name", students);

        // 2. Comparator.comparing(): you only say WHAT to compare.
        //    Student::getName is a method reference, short for student -> student.getName()
        //    reversed() flips the order. List.sort(comparator) does the same as Collections.sort(list, comparator)
        students.sort(Comparator.comparing(Student::getName).reversed());
        print("comparing + reversed - name, Z to A", students);

        // 3. comparingInt() is comparing() for int fields (it avoids boxing each int into an Integer)
        students.sort(Comparator.comparingInt(Student::getMarks));
        print("comparingInt - marks, lowest first", students);

        // 4. thenComparing(): the tie-breaker, used when the first field is equal
        students.sort(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName));
        print("thenComparing - age, then name", students);
    }

    private static void print(String title, List<Student> students) {
        System.out.println(title);
        for (Student student : students) {
            System.out.println("  " + student);
        }
        System.out.println();
    }
}
