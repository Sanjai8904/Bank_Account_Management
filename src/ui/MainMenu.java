package ui;
import model.Account;
import service.AccountService;
import java.util.*;

public class MainMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static final AccountService service = new AccountService();

    public static void start() {
        while (true) {
            System.out.println("\n=== BANK ACCOUNT MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> service.viewAllAccounts();
                case 6 -> {
                    System.out.println("👋 Exiting system... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    private static void createAccount() {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.next();
        System.out.print("Enter phone: ");
        String phone = sc.next();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(name, email, phone, balance);
        service.createAccount(acc);
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        service.deposit(accNo, amt);
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        service.withdraw(accNo, amt);
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        service.checkBalance(accNo);
    }
}
