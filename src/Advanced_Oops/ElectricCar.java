package Advanced_Oops;

// Child Class (Subclass) inheriting from Vehicle using 'extends'
public class ElectricCar extends Vehicle {

    private int batteryCapacityKWh;

    // Child Constructor
    public ElectricCar(String brand, int maxSpeed, int batteryCapacityKWh) {
        // 'super(...)' MUST be the first line: calls the parent Vehicle constructor
        super(brand, maxSpeed);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    // Method Overriding: Replacing parent's startEngine() behavior with EV-specific behavior
    @Override
    public void startEngine() {
        System.out.println(brand + " powered on silently using its " + batteryCapacityKWh + " kWh battery.");
    }

    // Child-specific method (Not available in Vehicle)
    public void chargeBattery() {
        System.out.println(brand + " is charging...");
    }
}
