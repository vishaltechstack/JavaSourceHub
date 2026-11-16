package Exceptions_Collections;

public class TryCatchFinallyDemo {

    public static void main(String[] args) {

        System.out.println("Program started...");

        try {
            // 1. 'try' block: Put risky code that might throw an exception here
            int[] numbers = {10, 20, 30};
            System.out.println("Accessing element: " + numbers[1]);

            int result = 100 / 0; // Throws ArithmeticException!
            System.out.println("This line will NOT execute: " + result);

        } catch (ArithmeticException e) {
            // 2. 'catch' block: Runs ONLY if ArithmeticException occurs
            System.out.println("Error caught: Cannot divide a number by zero!");
            System.out.println("Exception message: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            // You can chain multiple catch blocks from specific to general
            System.out.println("Error caught: Invalid array index accessed!");

        } catch (Exception e) {
            // Fallback catch block for any other unexpected exception
            System.out.println("General error: " + e.getMessage());

        } finally {
            // 3. 'finally' block: ALWAYS executes whether an exception occurred or not.
            // Ideal for closing files, database connections, or releasing resources.
            System.out.println("Finally block executed: Cleaning up resources.");
        }

        System.out.println("Program continued smoothly without crashing!");
    }
}