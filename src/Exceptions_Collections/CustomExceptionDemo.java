package Exceptions_Collections;

public class CustomExceptionDemo {

    // 'throws' in method signature warns callers that this method might throw InsufficientFundsException
    public static void processWithdrawal(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            // 'throw' explicitly triggers an exception object manually
            throw new InsufficientFundsException("Withdrawal of Rs. " + amount + " exceeds balance of Rs. " + balance);
        }
        System.out.println("Withdrawal successful! Remaining balance: Rs. " + (balance - amount));
    }

    public static void main(String[] args) {
        double currentBalance = 2000.0;

        try {
            processWithdrawal(currentBalance, 500.0);  // Succeeds
            processWithdrawal(currentBalance, 3500.0); // Triggers custom exception
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction Blocked -> " + e.getMessage());
        }
    }
}