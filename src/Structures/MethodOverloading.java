package Structures;

public class MethodOverloading {

    public static void main(String[] args) {
        // Java automatically picks the right method based on the arguments passed
        System.out.println("Area of square (side 5): " + calculateArea(5));
        System.out.println("Area of rectangle (4 x 6): " + calculateArea(4, 6));
        System.out.println("Area of circle (radius 3.5): " + calculateArea(3.5));
    }

    // Version 1: Takes 1 int (Square)
    public static int calculateArea(int side) {
        return side * side;
    }

    // Version 2: Takes 2 ints (Rectangle) - Different parameter count
    public static int calculateArea(int length, int width) {
        return length * width;
    }

    // Version 3: Takes 1 double (Circle) - Different parameter data type
    public static double calculateArea(double radius) {
        return 3.14159 * radius * radius;
    }
}
