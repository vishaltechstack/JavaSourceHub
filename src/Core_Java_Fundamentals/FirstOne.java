package Core_Java_Fundamentals;

// 1. Every Java program must live inside a class.
// The class name MUST match the file name (HelloWorld.java).
public class FirstOne {

    // 2. The main() method is the entry point where the JVM starts running your code.
    // public: Accessible from anywhere.
    // static: JVM can call this method without creating an object of HelloWorld first.
    // void: This method does not return any value.
    // String[] args: Accepts command-line arguments as an array of text.
    public static void main(String[] args) {
        // 3. System.out.println() prints text to the console and moves to a new line.
        System.out.println("Hello, Vishal! Welcome to Core Java.");

        // 4. System.out.print() prints text WITHOUT moving to a new line.
        System.out.print("Java is ");
        System.out.println("strongly typed and object-oriented.");
    }
}
