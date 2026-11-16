package JDBC;

public class JDBCRunner {

    public static void main(String[] args) {

        AccountDAO dao = new AccountDAO();
        BankTransactionService txService = new BankTransactionService();

        // 1. Create records
        dao.createAccount("Vishal Sharma", 10000.0);
        dao.createAccount("Rohan Verma", 4000.0);
        dao.getAllAccounts();

        // 2. Update a record
        dao.updateBalance(1, 12000.0);

        // 3. Execute atomic transaction (Transfer Rs. 2500 from ID 1 to ID 2)
        System.out.println("\n--- Testing Valid Bank Transfer ---");
        txService.transferFunds(1, 2, 2500.0);
        dao.getAllAccounts();

        // 4. Test Rollback (Trying to transfer to non-existent Account ID 999)
        System.out.println("\n--- Testing Failed Bank Transfer (Rollback) ---");
        txService.transferFunds(1, 999, 1000.0);
        dao.getAllAccounts(); // Notice ID 1's balance was NOT deducted!
    }
}
