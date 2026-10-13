package day5.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Day 5 - Practice: one small exercise that uses everything from today.
 *
 *   Task 1  Sort the products by price, lowest first (lambda Comparator).
 *   Task 2  Sort by quantity, highest first, then by name (Comparator.comparingInt + reversed + thenComparing).
 *   Task 3  Keep only the products that cost more than 1000 (generic method + Predicate lambda).
 *   Task 4  Add up all the prices in a List<Double> (wrapper classes + autoboxing).
 *   Task 5  Print every product name in upper case (forEach + lambda).
 */
public class PracticeDemo {

    // generic method: works for a list of any type; the condition is passed in as a lambda
    private static <T> List<T> filter(List<T> items, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 45000.0, 5));
        products.add(new Product(2, "Mouse", 499.0, 40));
        products.add(new Product(3, "Keyboard", 1500.0, 25));
        products.add(new Product(4, "Monitor", 12000.0, 10));
        products.add(new Product(5, "Pen Drive", 350.0, 40));

        // Task 1
        products.sort((first, second) -> Double.compare(first.getPrice(), second.getPrice()));
        print("Task 1 - price, lowest first", products);

        // Task 2
        products.sort(Comparator.comparingInt(Product::getQuantity).reversed().thenComparing(Product::getName));
        print("Task 2 - quantity (highest first), then name", products);

        // Task 3
        List<Product> expensive = filter(products, product -> product.getPrice() > 1000);
        print("Task 3 - price above 1000", expensive);

        // Task 4
        List<Double> prices = new ArrayList<>();
        for (Product product : products) {
            prices.add(product.getPrice());             // double -> Double (autoboxing)
        }
        double total = 0;
        for (double price : prices) {                   // Double -> double (unboxing)
            total += price;
        }
        System.out.println("Task 4 - total price: " + total);
        System.out.println();

        // Task 5
        System.out.println("Task 5 - names in upper case");
        products.forEach(product -> System.out.println("  " + product.getName().toUpperCase()));
    }

    private static void print(String title, List<Product> products) {
        System.out.println(title);
        for (Product product : products) {
            System.out.println("  " + product);
        }
        System.out.println();
    }
}
