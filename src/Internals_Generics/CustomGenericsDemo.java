package Internals_Generics;

// 1. Generic Class: 'T' is a placeholder for whatever type the caller specifies
class DataContainer<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// 2. Bounded Type Parameter (<N extends Number>):
// Restricts 'N' to ONLY Number and its subclasses (Integer, Double, Long, etc.)
class MathCalculator<N extends Number> {
    private N num1;
    private N num2;

    public MathCalculator(N num1, N num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sumAsDouble() {
        // Because N extends Number, we can safely call .doubleValue()
        return num1.doubleValue() + num2.doubleValue();
    }
}

public class CustomGenericsDemo {

    // 3. Generic Method: Works on arrays of any reference type
    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Using DataContainer with String
        DataContainer<String> textBox = new DataContainer<>();
        textBox.setValue("Type-Safe Java");
        // textBox.setValue(123); // COMPILE ERROR! Prevents accidental type mixing
        System.out.println("String Container: " + textBox.getValue());

        // Using DataContainer with Integer
        DataContainer<Integer> intBox = new DataContainer<>();
        intBox.setValue(42);
        System.out.println("Integer Container: " + intBox.getValue());

        // Using Bounded Generic Class
        MathCalculator<Double> calc = new MathCalculator<>(12.5, 7.5);
        System.out.println("Bounded Generic Sum: " + calc.sumAsDouble());

        // Using Generic Method
        String[] langs = {"Java", "Kotlin", "Scala"};
        Integer[] nums = {10, 20, 30};
        printArray(langs);
        printArray(nums);
    }
}