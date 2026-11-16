package Core_Java_Fundamentals;

public class OperatorsAndTypeCasting {

    public static void main(String[] args) {

        // 1. Arithmetic Operators
        int a = 15;
        int b = 4;

        System.out.println("Addition: " + (a + b));       // 19
        System.out.println("Subtraction: " + (a - b));    // 11
        System.out.println("Multiplication: " + (a * b)); // 60

        // Integer division drops the decimal part (15 / 4 = 3, not 3.75)
        System.out.println("Integer Division: " + (a / b));

        // Modulus (%) gives the REMAINDER of division (15 divided by 4 leaves remainder 3)
        System.out.println("Remainder (Modulus): " + (a % b));

        // 2. Type Casting (Converting one data type to another)

        // Widening Casting (Automatic): Smaller type -> Larger type (No data loss)
        int myInt = 10;
        double myDouble = myInt; // Automatically converts 10 to 10.0
        System.out.println("Widened double: " + myDouble);

        // Narrowing Casting (Manual): Larger type -> Smaller type (Risk of data loss)
        double rawScore = 88.75;
        int roundedScore = (int) rawScore; // Must explicitly put (int); drops .75
        System.out.println("Narrowed int: " + roundedScore);

        // 3. Relational & Logical Operators (Always evaluate to true or false)
        int age = 22;
        boolean hasID = true;

        // '&&' (Logical AND): Both conditions must be true
        boolean canEnter = (age >= 18) && hasID;
        System.out.println("Allowed entry: " + canEnter);
    }
}
