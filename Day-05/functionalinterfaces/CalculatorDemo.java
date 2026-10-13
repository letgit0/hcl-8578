package day5.functionalinterfaces;

/**
 * Day 5 - One functional interface, three ways to implement it: class, anonymous class, lambda.
 */
public class CalculatorDemo {

    // 1. a normal class that implements the interface
    static class Addition implements Calculator {

        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    }

    // a method that receives the operation as a parameter
    static int operate(int a, int b, Calculator calculator) {
        return calculator.calculate(a, b);
    }

    public static void main(String[] args) {
        Calculator addition = new Addition();
        addition.show(10, 5);                           // 15

        // 2. anonymous class: no named class, but still a lot of code
        Calculator subtraction = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a - b;
            }
        };
        subtraction.show(10, 5);                        // 5

        // 3. lambda expression: (parameters) -> result
        Calculator multiplication = (a, b) -> a * b;
        multiplication.show(10, 5);                     // 50

        // lambda with a block body: braces and an explicit return
        Calculator division = (a, b) -> {
            if (b == 0) {
                System.out.println("Cannot divide by zero");
                return 0;
            }
            return a / b;
        };
        division.show(10, 5);                           // 2
        division.show(10, 0);                           // 0

        // a lambda can be passed straight to a method
        System.out.println("10 % 3 = " + operate(10, 3, (a, b) -> a % b));             // 1
        System.out.println("max(10, 3) = " + operate(10, 3, Math::max));                // 10 (method reference)
    }
}
