package Advanced_Oops;

public class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
        super(color); // Calls Shape's constructor
        this.radius = radius;
    }

    // Fulfilling the contract forced by the abstract parent class
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
