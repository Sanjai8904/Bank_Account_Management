package service;
import database.DBConnection;
import model.Account;
import java.sql.*;
// import java.util.*;

public class AccountService {
    private Connection conn;

    public AccountService() {
        conn = DBConnection.getConnection();
    }

    // Create account
    public void createAccount(Account account) {
        String sql = "INSERT INTO accounts (name, email, phone, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, account.getName());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPhone());
            ps.setDouble(4, account.getBalance());
            ps.executeUpdate();
            System.out.println("✅ Account created successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error creating account: " + e.getMessage());
        }
    }

    // Deposit money
    public void deposit(int accNo, double amount) {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("💰 Deposit successful!");
            else System.out.println("❌ Account not found!");
        } catch (SQLException e) {
            System.out.println("❌ Deposit failed: " + e.getMessage());
        }
    }

    // Withdraw money
    public void withdraw(int accNo, double amount) {
        String query = "SELECT balance FROM accounts WHERE account_no = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (balance >= amount) {
                    String update = "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";
                    try (PreparedStatement ps2 = conn.prepareStatement(update)) {
                        ps2.setDouble(1, amount);
                        ps2.setInt(2, accNo);
                        ps2.executeUpdate();
                        System.out.println("💸 Withdrawal successful!");
                    }
                } else {
                    System.out.println("❌ Insufficient balance!");
                }
            } else {
                System.out.println("❌ Account not found!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Withdrawal failed: " + e.getMessage());
        }
    }

    // Check balance
    public void checkBalance(int accNo) {
        String sql = "SELECT name, balance FROM accounts WHERE account_no = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("👤 Name: " + rs.getString("name"));
                System.out.println("💵 Balance: ₹" + rs.getDouble("balance"));
            } else {
                System.out.println("❌ Account not found!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error checking balance: " + e.getMessage());
        }
    }

    // View all accounts
    public void viewAllAccounts() {
        String sql = "SELECT * FROM accounts";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== All Accounts ===");
            while (rs.next()) {
                System.out.println("Account No: " + rs.getInt("account_no") +
                        " | Name: " + rs.getString("name") +
                        " | Balance: ₹" + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch accounts: " + e.getMessage());
        }
    }
}
