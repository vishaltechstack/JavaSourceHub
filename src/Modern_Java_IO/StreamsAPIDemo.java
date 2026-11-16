package Modern_Java_IO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAPIDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(12, 5, 8, 21, 14, 3, 18, 8);

        // 1. Filtering, Transforming (map), Sorting, and Collecting
        List<Integer> processedNumbers = numbers.stream() // Source
                .filter(n -> n > 7)                     // Keep numbers greater than 7
                .distinct()                             // Remove duplicates (removes extra 8)
                .map(n -> n * 2)                        // Multiply each remaining number by 2
                .sorted()                               // Sort in ascending order
                .collect(Collectors.toList());          // Terminal operation: gather into new List

        System.out.println("Original List (Unchanged): " + numbers);
        System.out.println("Processed Stream List: " + processedNumbers);

        // 2. Working with Strings & Method References (System.out::println)
        List<String> names = Arrays.asList("vishal", "arjun", "neha", "vikram", "ananya");

        System.out.println("\n--- Names starting with 'v' in Uppercase ---");
        names.stream()
                .filter(name -> name.startsWith("v"))
                .map(String::toUpperCase)      // Method reference shorthand for: name -> name.toUpperCase()
                .forEach(System.out::println); // Method reference shorthand for: s -> System.out.println(s)

        // 3. Aggregation using reduce()
        int totalSum = numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("\nSum of all numbers: " + totalSum);
    }
}