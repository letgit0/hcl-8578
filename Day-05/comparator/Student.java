package day5.comparator;

/**
 * Day 5 - Comparable: the class defines its own "natural order" inside compareTo().
 *
 * Same idea as Day 4: Student orders itself by age first, then by marks when the ages are equal.
 * Every other order (name, marks, ...) is written outside this class as a Comparator - see NameComparator
 * and ComparatorDemo.
 */
public class Student implements Comparable<Student> {

    private final int rollNo;
    private final String name;
    private final int age;
    private final int marks;

    public Student(int rollNo, String name, int age, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    // negative: this comes before other, zero: same position, positive: this comes after other
    @Override
    public int compareTo(Student other) {
        if (this.age != other.age) {
            return Integer.compare(this.age, other.age);    // youngest first
        }
        return Integer.compare(this.marks, other.marks);    // same age: lowest marks first
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}
