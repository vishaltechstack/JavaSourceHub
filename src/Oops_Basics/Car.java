package Oops_Basics;

// Blueprint class (No main method here—this defines what a Car IS and DOES)
public class Car {

    // 1. Instance Variables (Fields / Attributes)
    // Each Car object created will get its own separate copy of these variables.
    String brand;
    String model;
    int year;
    double speed;

    // 2. Instance Methods (Behaviors)
    public void accelerate(double increaseBy) {
        speed += increaseBy;
        System.out.println(brand + " " + model + " accelerated to " + speed + " km/h.");
    }

    public void displaySpecs() {
        System.out.println("Car: " + year + " " + brand + " " + model + " | Current Speed: " + speed + " km/h");
    }
}
