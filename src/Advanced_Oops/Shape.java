package Advanced_Oops;

// Abstract class: Defines WHAT a Shape must do, without knowing HOW every shape calculates it
public abstract class Shape {

    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Abstract method (No body): Every subclass MUST override and implement this
    public abstract double calculateArea();

    // Concrete method (Has body): Shared directly by all subclasses
    public void displayColor() {
        System.out.println("Shape color: " + color);
    }
}
