package Advanced_Oops;

// Parent Class (Superclass)
public class Vehicle {

    // 'protected' allows access within the same package AND in subclasses (even in other packages)
    protected String brand;
    protected int maxSpeed;

    // Parent Constructor
    public Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    // Method that will be inherited by child classes
    public void startEngine() {
        System.out.println(brand + " engine started with a standard ignition.");
    }

    public void showInfo() {
        System.out.println("Brand: " + brand + " | Max Speed: " + maxSpeed + " km/h");
    }
}
