package Oops_Basics;

public class BankAccount {

    // 1. 'private' fields: Cannot be accessed directly like account.balance = -5000;
    private String accountHolder;
    private double balance;

    // Constructor to initialize account safely
    public BankAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        if (initialDeposit >= 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = 0;
            System.out.println("Initial deposit cannot be negative. Balance set to 0.");
        }
    }

    // 2. Getter Method (Read-only access to private data)
    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // 3. Controlled Setter / Business Methods (Protects data integrity)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount + " | New Balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew Rs. " + amount + " | Remaining Balance: Rs. " + balance);
        } else {
            System.out.println("Transaction failed: Insufficient balance or invalid amount.");
        }
    }
}
