package Modern_Java_IO;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// 1. Custom Functional Interface (Can have only ONE abstract method)
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdasAndFunctionalInterfaces {

    public static void main(String[] args) {

        // 2. Implementing custom Functional Interface using Lambda Expressions
        // Syntax: (parameters) -> { body }
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("Addition via Lambda: " + addition.operate(10, 5));         // 15
        System.out.println("Multiplication via Lambda: " + multiplication.operate(10, 5)); // 50

        // 3. Built-in Functional Interfaces in java.util.function:

        // Predicate<T>: Takes an input T, returns a boolean (Used for conditions/filtering)
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 14 even? " + isEven.test(14)); // true

        // Function<T, R>: Takes input T, transforms and returns output R
        Function<String, Integer> getLength = str -> str.length();
        System.out.println("Length of 'Java': " + getLength.apply("Java")); // 4

        // Consumer<T>: Takes input T, performs an action, returns nothing (void)
        Consumer<String> printer = msg -> System.out.println("Log: " + msg);
        printer.accept("Lambda executed cleanly!");
    }
}