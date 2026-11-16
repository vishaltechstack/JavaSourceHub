package Internals_Generics;

class Box {
    // Instance variable: Lives INSIDE the Box object on the HEAP
    int width;

    public Box(int width) {
        this.width = width;
    }
}

public class StackVsHeapMemoryDemo {

    public static void main(String[] args) {

        // 1. Primitive local variable: Value '10' is stored directly on the STACK
        int number = 10;
        modifyPrimitive(number);
        // 'number' is STILL 10 because Java passes primitives by value (a copy on the Stack)
        System.out.println("Primitive after method call: " + number);

        // 2. Object creation:
        // 'boxRef' (reference variable) lives on the STACK.
        // 'new Box(20)' (actual object with width=20) lives on the HEAP.
        Box boxRef = new Box(20);
        modifyObject(boxRef);
        // 'boxRef.width' is NOW 99 because both Stack references point to the SAME Heap object!
        System.out.println("Object width after method call: " + boxRef.width);

        // 3. String Pool (Special region inside Heap)
        String s1 = "Java";                  // Stored in String Constant Pool (Heap)
        String s2 = "Java";                  // Reuses exact same pool reference!
        String s3 = new String("Java");      // Forces creation of a brand-new Heap object outside pool

        System.out.println("s1 == s2 (Same pool reference): " + (s1 == s2)); // true
        System.out.println("s1 == s3 (Different Heap objects): " + (s1 == s3)); // false
    }

    private static void modifyPrimitive(int x) {
        x = 50; // Modifies only local copy 'x' in modifyPrimitive's Stack frame
    }

    private static void modifyObject(Box b) {
        b.width = 99; // Follows reference 'b' to the Heap and mutates the actual object
    }
}