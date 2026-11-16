package Advanced_Oops;

// Implementing the Payable interface using the 'implements' keyword
public class UPIPayment implements Payable {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    // Must provide implementation for interface's abstract method
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing " + CURRENCY + " " + amount + " via UPI ID: " + upiId);
        printReceipt(amount); // Calling default method inherited from Payable
    }
}