package Core_Java_Fundamentals;

public class Loops {

    public static void main(String[] args) {

        // 1. FOR LOOP: Use when you know the exact number of iterations.
        // Syntax: for (initialization; condition; update)
        System.out.println("--- For Loop (1 to 5) ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        // 2. WHILE LOOP: Use when you want to repeat UNTIL a condition becomes false.
        // Checks condition BEFORE running the block.
        System.out.println("\n--- While Loop (Countdown) ---");
        int timer = 3;
        while (timer > 0) {
            System.out.println("Seconds left: " + timer);
            timer--; // Decrement timer by 1 (if forgotten, creates an infinite loop!)
        }

        // 3. DO-WHILE LOOP: Runs the code block AT LEAST ONCE before checking the condition.
        System.out.println("\n--- Do-While Loop ---");
        int number = 10;
        do {
            System.out.println("This prints once even though 10 is not less than 5.");
            number++;
        } while (number < 5);

        // 4. break and continue keywords
        System.out.println("\n--- Break & Continue ---");
        for (int i = 1; i <= 6; i++) {
            if (i == 3) {
                continue; // Skips the rest of iteration 3 and jumps to 4
            }
            if (i == 5) {
                break;    // Completely exits the loop when i hits 5
            }
            System.out.println("Processed number: " + i); // Prints 1, 2, 4
        }
    }
}
