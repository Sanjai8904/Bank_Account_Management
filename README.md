🏦 Bank Account Management System

A simple Java + MySQL project to manage bank accounts — allowing users to create, update, delete, and view account details through a command-line interface.

🚀 Features

-Create new bank accounts
-Deposit and withdraw money
-Check account balance
-View all customer accounts
-Delete an account
-Persistent data storage using MySQL
-Modular code with multiple packages

🧩 Project Structure

Bank_acc_management/
│
├── lib/
│   └── mysql-connector-j-9.4.0.jar      # JDBC driver
│
├── src/
│   ├── Main.java                        # Entry point
│   ├── database/DBconnection.java        # MySQL connection
│   ├── model/Account.java                # Data model
│   ├── service/AccountService.java       # Business logic
│   └── ui/MainMenu.java                  # CLI menu
│
└── README.md

⚙️ Technologies Used

-Java (JDK 21)
-MySQL Database
-JDBC Connector
