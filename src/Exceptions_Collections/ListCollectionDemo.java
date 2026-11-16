package Exceptions_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCollectionDemo {

    public static void main(String[] args) {

        // Programming to the interface: Reference type is List, object type is ArrayList
        List<String> languages = new ArrayList<>();

        // 1. Adding elements (Maintains insertion order)
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java"); // Duplicates are allowed in a List

        System.out.println("Full List: " + languages);

        // 2. Accessing & Updating by index
        System.out.println("Element at index 1: " + languages.get(1)); // Python
        languages.set(2, "Go"); // Replaces "C++" with "Go"

        // 3. Removing elements & checking size
        languages.remove("Java"); // Removes the first occurrence of "Java"
        System.out.println("After removal: " + languages + " | Size: " + languages.size());

        // 4. Sorting a List using Collections utility class
        Collections.sort(languages);
        System.out.println("Sorted Alphabetically: " + languages);

        // 5. Iterating through the List
        System.out.println("\n--- Iterating List ---");
        for (String lang : languages) {
            System.out.println("- " + lang);
        }
    }
}