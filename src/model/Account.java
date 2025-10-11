package model;

public class Account {
    private int accountNo;
    private String name;
    private String email;
    private String phone;
    private double balance;

    public Account(int accountNo, String name, String email, String phone, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public Account(String name, String email, String phone, double balance) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    public int getAccountNo() { return accountNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public double getBalance() { return balance; }

    public void setAccountNo(int accountNo) { this.accountNo = accountNo; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "\nAccount No: " + accountNo +
               "\nName: " + name +
               "\nEmail: " + email +
               "\nPhone: " + phone +
               "\nBalance: ₹" + balance;
    }
}

