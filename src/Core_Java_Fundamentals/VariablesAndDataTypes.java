package Core_Java_Fundamentals;

public class VariablesAndDataTypes {

    public static void main(String[] args) {

        // --- PRIMITIVE DATA TYPES (Store simple values directly in memory) ---

        // 1. Whole Numbers
        byte smallNumber = 100;             // 1 byte (-128 to 127)
        short mediumNumber = 30000;         // 2 bytes (-32,768 to 32,767)
        int age = 24;                       // 4 bytes (Most commonly used for integers)
        long worldPopulation = 8100000000L; // 8 bytes (Notice the 'L' at the end for long)

        // 2. Decimal Numbers
        float price = 99.95f;               // 4 bytes (Notice the 'f' at the end for float)
        double precisePi = 3.14159265359;   // 8 bytes (Default and more accurate for decimals)

        // 3. Single Character & True/False
        char grade = 'A';                   // 2 bytes (Always use single quotes for char)
        boolean isJavaFun = true;           // 1 bit (Only true or false)

        // --- NON-PRIMITIVE DATA TYPE (Reference Type) ---
        // String is a class in Java, not a primitive type. Always use double quotes.
        String developerName = "Vishal";

        // Concatenating (joining) text and variables using the '+' operator
        System.out.println("Name: " + developerName);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Exact Pi: " + precisePi);
        System.out.println("Is Java Fun? " + isJavaFun);
    }
}
