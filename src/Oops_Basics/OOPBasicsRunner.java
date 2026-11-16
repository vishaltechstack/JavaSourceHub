package Oops_Basics;

public class OOPBasicsRunner {

    public static void main(String[] args) {

        // --- 1. Testing Car (Classes & Objects) ---
        System.out.println("=== 1. CLASSES & OBJECTS ===");
        Car car1 = new Car(); // Creating object 1
        car1.brand = "Honda";
        car1.model = "City";
        car1.year = 2024;
        car1.accelerate(60);
        car1.displaySpecs();

        Car car2 = new Car(); // Creating independent object 2
        car2.brand = "Tata";
        car2.model = "Nexon";
        car2.year = 2025;
        car2.accelerate(85);
        car2.displaySpecs();

        // --- 2. Testing Book (Constructors) ---
        System.out.println("\n=== 2. CONSTRUCTORS ===");
        Book defaultBook = new Book(); // Calls no-arg constructor
        Book customBook = new Book("Effective Java", "Joshua Bloch", 650.0); // Calls parameterized constructor
        defaultBook.printDetails();
        customBook.printDetails();

        // --- 3. Testing BankAccount (Encapsulation) ---
        System.out.println("\n=== 3. ENCAPSULATION ===");
        BankAccount acc = new BankAccount("Vishal", 5000.0);
        // acc.balance = -9999; // COMPILE ERROR! 'balance' is private and protected.
        acc.deposit(2500.0);
        acc.withdraw(10000.0); // Blocked by validation logic inside withdraw()
        acc.withdraw(1500.0);
        System.out.println("Final Verified Balance: Rs. " + acc.getBalance());

        // --- 4. Testing Employee (Static Keyword) ---
        System.out.println("\n=== 4. STATIC MEMBERS ===");
        Employee e1 = new Employee(101, "Vishal");
        Employee e2 = new Employee(102, "Aarav");
        e1.showEmployee();
        e2.showEmployee();

        // Calling static method directly via class name
        Employee.showTotalEmployees();
    }
}
