package day5.generics;

/**
 * Day 5 - A generic class: T is a placeholder for a real type that is chosen when the object is created.
 *
 * Box<Integer> holds an Integer, Box<String> holds a String - one class for all of them.
 */
public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box[" + value + "]";
    }
}
