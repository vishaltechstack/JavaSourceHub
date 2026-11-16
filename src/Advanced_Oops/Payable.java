package Advanced_Oops;

// Interface: Defines a contract for any payment method
public interface Payable {

    // Variables in interfaces are implicitly 'public static final' (constants)
    String CURRENCY = "INR";

    // Methods without a body are implicitly 'public abstract'
    void processPayment(double amount);

    // Java 8+ allows 'default' methods with a body inside interfaces
    default void printReceipt(double amount) {
        System.out.println("Receipt: Paid " + CURRENCY + " " + amount + " successfully.");
    }
}
