import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class custom_exception {
    public static void main(String[] args) {

        ArrayList<Integer> numbers =
                new ArrayList<>(Arrays.asList(10, 15, 20, 25, 30, 35));

        List<Integer> result = numbers.stream()
                .filter(n -> n > 20)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
----
public static void main(String[] args){
    ArrayList<String> names =
                new ArrayList<>(Arrays.asList("Hema", "Chris", "Suda", "ada"));
    List<String> result = names.stream().filter(a -> a.startsWith("a")).collect(Collectors.toList());
}
TAsk 1
names starting with A, toUpperCase, sorted
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Andrew", "anna", "Charlie", "Alex");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);
    }
}
---
total salary per dept
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String dept;
    double salary;

    Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "IT", 60000),
            new Employee("Bob", "HR", 40000),
            new Employee("Charlie", "IT", 70000),
            new Employee("David", "HR", 50000),
            new Employee("Eve", "Finance", 80000)
        );

        Map<String, Double> totalSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.dept,
                Collectors.summingDouble(e -> e.salary)
            ));

        totalSalaryByDept.forEach((dept, total) ->
            System.out.println(dept + " = " + total)
        );
    }
}
---
top 3 highest paid employees
stretch :word freq using streams