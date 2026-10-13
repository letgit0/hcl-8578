package day5.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Day 5 - Comparable vs Comparator.
 *
 * Comparable: the class itself says how it is ordered (compareTo, written inside Student) - one natural order.
 * Comparator: the order is written outside the class (compare), so there can be as many orders as you like
 *             and Student does not have to change.
 *
 * This demo: the Comparable order first (Student.compareTo), then a Comparator as a separate class and as an anonymous class.
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Asha", 20, 78));
        students.add(new Student(102, "Ravi", 19, 85));
        students.add(new Student(103, "Meera", 20, 65));
        students.add(new Student(104, "John", 21, 90));
        students.add(new Student(105, "Kiran", 19, 70));

        // 1. Comparable: Collections.sort(list) calls Student.compareTo() -> age, then marks
        Collections.sort(students);
        print("Comparable - age, then marks", students);

        // 2. Comparator as a separate class: Collections.sort(list, comparator) -> name, A to Z
        Collections.sort(students, new NameComparator());
        print("Comparator class - name", students);

        // 3. Comparator as an anonymous class (no extra file) -> marks, highest first
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student first, Student second) {
                return Integer.compare(second.getMarks(), first.getMarks());    // arguments swapped = descending
            }
        });
        print("Anonymous Comparator - marks, highest first", students);
    }

    private static void print(String title, List<Student> students) {
        System.out.println(title);
        for (Student student : students) {
            System.out.println("  " + student);
        }
        System.out.println();
    }
}
