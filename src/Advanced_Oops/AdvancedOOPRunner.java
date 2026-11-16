package Advanced_Oops;

public class AdvancedOOPRunner {

    public static void main(String[] args) {

        // --- 1. INHERITANCE & RUNTIME POLYMORPHISM ---
        System.out.println("=== 1. INHERITANCE & METHOD OVERRIDING ===");
        Vehicle regularCar = new Vehicle("Maruti", 160);
        regularCar.startEngine(); // Calls Vehicle's version

        // Upcasting: Parent reference (Vehicle) pointing to Child object (ElectricCar)
        // JVM decides at RUNTIME which startEngine() to execute based on the actual object!
        Vehicle ev = new ElectricCar("Tata Nexon EV", 180, 40);
        ev.showInfo();    // Inherited from Vehicle
        ev.startEngine(); // Calls ElectricCar's overridden version!

        // --- 2. ABSTRACTION (ABSTRACT CLASS) ---
        System.out.println("\n=== 2. ABSTRACT CLASS ===");
        // Shape s = new Shape("Red"); // COMPILE ERROR! Cannot instantiate abstract class.
        Shape myCircle = new Circle("Blue", 5.0);
        myCircle.displayColor();
        System.out.printf("Circle Area: %.2f\n", myCircle.calculateArea());

        // --- 3. INTERFACES ---
        System.out.println("\n=== 3. INTERFACES ===");
        // Interface reference pointing to implementing class object
        Payable payment = new UPIPayment("vishal@okaxis");
        payment.processPayment(1250.00);
    }
}