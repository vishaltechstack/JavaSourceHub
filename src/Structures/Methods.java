package Structures;

public class Methods {

    public static void main(String[] args) {
        // Calling a void method (performs an action, returns nothing)
        greetUser("Vishal");

        // Calling a method that returns an int value and storing it
        int sum = addNumbers(15, 25);
        System.out.println("Sum is: " + sum);

        // Passing an array into a method
        int[] data = {12, 45, 7, 89, 23};
        int maxVal = findMax(data);
        System.out.println("Maximum value in array: " + maxVal);
    }

    // 1. Method with parameter and no return value (void)
    public static void greetUser(String name) {
        System.out.println("Welcome back, " + name + "!");
    }

    // 2. Method with two parameters and an 'int' return type
    public static int addNumbers(int num1, int num2) {
        int result = num1 + num2;
        return result; // Sends the calculated value back to the caller
    }

    // 3. Method accepting an array and returning the largest element
    public static int findMax(int[] numbers) {
        int max = numbers[0]; // Assume first element is largest
        for (int num : numbers) {
            if (num > max) {
                max = num; // Update max if a larger number is found
            }
        }
        return max;
    }
}
