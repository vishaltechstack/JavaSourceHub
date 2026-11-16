package Structures;

public class ArraysBasics {

    public static void main(String[] args) {

        // 1. Declaring and initializing a 1D array directly
        // Index always starts at 0. Here, length is 4 (indices: 0, 1, 2, 3).
        int[] scores = {85, 92, 78, 95};

        // Accessing and modifying elements using index
        System.out.println("First score: " + scores[0]); // Prints 85
        scores[2] = 80; // Updates 78 to 80

        // 2. Looping through an array using standard for loop
        System.out.println("\n--- All Scores (Standard Loop) ---");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index " + i + ": " + scores[i]);
        }

        // 3. Enhanced For-Each Loop (Cleaner when you don't need the index)
        System.out.println("\n--- All Scores (For-Each Loop) ---");
        int total = 0;
        for (int s : scores) {
            total += s; // Adds each score to total
        }
        System.out.println("Average Score: " + (total / scores.length));

        // 4. 2D Array (Matrix: Rows x Columns)
        int[][] matrix = {
                {1, 2, 3}, // Row 0
                {4, 5, 6}  // Row 1
        };

        System.out.println("\nElement at Row 1, Column 2: " + matrix[1][2]); // Prints 6
    }
}
