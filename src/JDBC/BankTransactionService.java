package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransactionService {

    public void transferFunds(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        Connection conn = null;

        try {
            conn = DBConnectionManager.getConnection();

            // 1. Turn OFF auto-commit to start an atomic transaction block
            conn.setAutoCommit(false);

            // Step A: Debit sender
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                debitStmt.setDouble(3, amount); // Ensures sufficient balance

                int debitedRows = debitStmt.executeUpdate();
                if (debitedRows == 0) {
                    throw new SQLException("Debit failed: Insufficient funds or invalid sender ID.");
                }
            }

            // Step B: Credit receiver
            try (PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);

                int creditedRows = creditStmt.executeUpdate();
                if (creditedRows == 0) {
                    throw new SQLException("Credit failed: Receiver account ID does not exist.");
                }
            }

            // 2. Both steps succeeded! Permanently save changes to the database
            conn.commit();
            System.out.println("TRANSACTION COMMITTED: Transferred Rs. " + amount +
                    " from ID " + fromAccountId + " to ID " + toAccountId);

        } catch (SQLException e) {
            // 3. Something failed! Undo ALL changes made during this transaction
            System.out.println("TRANSACTION ERROR: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("ROLLBACK EXECUTED: Database restored to safe previous state.");
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
        } finally {
            // 4. Restore default auto-commit mode and close connection cleanly
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException closeEx) {
                    System.out.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }
}