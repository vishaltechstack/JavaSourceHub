package Core_Java_Fundamentals;

public class ControlFlowStatements {

    public static void main(String[] args) {

        int marks = 82;

        // 1. if - else if - else ladder
        // Java checks conditions top-to-bottom and executes ONLY the first true block.
        if (marks >= 90) {
            System.out.println("Result: Distinction (A+)");
        } else if (marks >= 75) {
            System.out.println("Result: First Class (A)");
        } else if (marks >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }

        // 2. Modern Switch Expression (Clean way to check exact matches)
        int dayNumber = 3;

        String dayName = switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend"; // Multiple cases combined
            default -> "Invalid day";
        };

        System.out.println("Day " + dayNumber + " is: " + dayName);
    }
}
