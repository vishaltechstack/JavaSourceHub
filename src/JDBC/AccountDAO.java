package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    // 1. CREATE (INSERT)
    public void createAccount(String holderName, double initialBalance) {
        String sql = "INSERT INTO accounts (holder_name, balance) VALUES (?, ?)";

        // try-with-resources automatically closes Connection and PreparedStatement when done!
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind values to '?' placeholders (1-based index, NOT 0-based!)
            pstmt.setString(1, holderName);
            pstmt.setDouble(2, initialBalance);

            // executeUpdate() is used for INSERT, UPDATE, DELETE; returns number of rows affected
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " record for: " + holderName);

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // 2. READ (SELECT with ResultSet)
    public void getAllAccounts() {
        String sql = "SELECT account_id, holder_name, balance FROM accounts";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             // executeQuery() is used ONLY for SELECT statements; returns a ResultSet cursor
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Current Database Records ---");
            // rs.next() moves the cursor forward one row at a time; returns false when no rows remain
            while (rs.next()) {
                int id = rs.getInt("account_id");
                String name = rs.getString("holder_name");
                double balance = rs.getDouble("balance");

                System.out.printf("ID: %d | Holder: %-15s | Balance: Rs. %.2f\n", id, name, balance);
            }

        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }

    // 3. UPDATE
    public void updateBalance(int accountId, double newBalance) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountId);

            int rows = pstmt.executeUpdate();
            System.out.println("Updated " + rows + " account(s) for ID: " + accountId);

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // 4. DELETE
    public void deleteAccount(int accountId) {
        String sql = "DELETE FROM accounts WHERE account_id = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, accountId);

            int rows = pstmt.executeUpdate();
            System.out.println("Deleted " + rows + " account(s) for ID: " + accountId);

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}