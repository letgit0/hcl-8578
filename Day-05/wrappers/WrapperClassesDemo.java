package day5.wrappers;

/**
 * Day 5 - Wrapper classes: every primitive type has a class that wraps its value in an object.
 *
 * byte - Byte, short - Short, int - Integer, long - Long,
 * float - Float, double - Double, char - Character, boolean - Boolean
 *
 * Why: collections and generics can only hold objects, and wrappers add useful methods (parsing, comparing, ...).
 */
public class WrapperClassesDemo {

    public static void main(String[] args) {
        // creating wrapper objects: use valueOf() ("new Integer(25)" is deprecated)
        Integer age = Integer.valueOf(25);
        Double price = Double.valueOf(99.5);
        Character grade = Character.valueOf('A');
        Boolean passed = Boolean.valueOf(true);
        System.out.println(age + " " + price + " " + grade + " " + passed);

        // wrapper -> primitive
        int ageValue = age.intValue();
        double ageAsDouble = age.doubleValue();
        System.out.println("intValue: " + ageValue + ", doubleValue: " + ageAsDouble);

        // String -> number (parsing)
        int count = Integer.parseInt("123");
        double amount = Double.parseDouble("45.75");
        boolean flag = Boolean.parseBoolean("true");
        System.out.println(count + 1);                  // 124: it is a number now, not text
        System.out.println(amount + " " + flag);

        // text that is not a number -> NumberFormatException
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse: " + e.getMessage());
        }

        // number -> String
        String text = Integer.toString(42);
        System.out.println(text + "!");                 // 42!

        // constants and helper methods
        System.out.println("int range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("Character.isDigit('7'): " + Character.isDigit('7'));
        System.out.println("Character.isLetter('7'): " + Character.isLetter('7'));
        System.out.println("Character.toUpperCase('k'): " + Character.toUpperCase('k'));

        // comparing: wrappers implement Comparable, which is why Collections.sort() works on a List<Integer>
        Integer ten = Integer.valueOf(10);
        System.out.println("ten.compareTo(20): " + ten.compareTo(20));          // -1
        System.out.println("ten.equals(10): " + ten.equals(10));                // true
        System.out.println("Integer.compare(30, 20): " + Integer.compare(30, 20));    // 1
    }
}
