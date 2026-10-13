package day5.comparator;

import java.util.Comparator;

/**
 * Day 5 - A Comparator written as a separate class.
 *
 * Student already has its natural order (Comparable: age, then marks). This class adds ONE more order,
 * by name, without changing Student at all.
 */
public class NameComparator implements Comparator<Student> {

    // negative: first comes before second, zero: same position, positive: first comes after second
    @Override
    public int compare(Student first, Student second) {
        return first.getName().compareTo(second.getName());     // String is Comparable, so A to Z
    }
}
