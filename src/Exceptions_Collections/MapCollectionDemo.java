package Exceptions_Collections;

import java.util.HashMap;
import java.util.Map;

public class MapCollectionDemo {

    public static void main(String[] args) {

        // Key: String (Student Name), Value: Integer (Score)
        Map<String, Integer> studentScores = new HashMap<>();

        // 1. Adding Key-Value pairs using put()
        studentScores.put("Vishal", 94);
        studentScores.put("Rohan", 88);
        studentScores.put("Ananya", 97);

        // Putting an existing key OVERWRITES its previous value
        studentScores.put("Rohan", 91);

        // 2. Retrieving values using get() and getOrDefault()
        System.out.println("Vishal's Score: " + studentScores.get("Vishal"));
        System.out.println("Unknown Student: " + studentScores.getOrDefault("Karan", 0)); // Avoids null

        // 3. Checking existence
        System.out.println("Has key 'Ananya'? " + studentScores.containsKey("Ananya"));

        // 4. Iterating over all Key-Value pairs using entrySet()
        System.out.println("\n--- All Student Records ---");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " -> Marks: " + entry.getValue());
        }
    }
}