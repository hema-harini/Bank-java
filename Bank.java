import java.util.Date;

// Enumeration for Transaction Type
enum TransactionType {
    DEPOSIT, WITHDRAWAL, TRANSFER
}

// Enumeration for Account Type
enum AccountType {
    SAVINGS, CHECKING, CREDIT
}

// Enumeration for Transaction Status
enum Status {
    PENDING, COMPLETED, FAILED
}

// Enumeration for Alert Type
enum AlertType {
    LOW_BALANCE, LARGE_TRANSACTION, UNUSUAL_ACTIVITY
}

// User class
class User {
    private String username;
    private String password;
    private String biometricData;

    public User(String username, String password, String biometricData) {
        this.username = username;
        this.password = password;
        this.biometricData = biometricData;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBiometricData() {
        return biometricData;
    }

    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBiometricData(String biometricData) {
        this.biometricData = biometricData;
    }

    // Additional methods
    public void authenticate(String enteredUsername, String enteredPassword) {
        // Implementation to authenticate the user
        // Check if enteredUsername and enteredPassword match the stored values
        if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}


// Account class
class Account {
    private String accountId;
    private double balance;
    private AccountType accountType;

    public Account(String accountId, double balance, AccountType accountType) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Getter methods
    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit of $" + amount + " completed. New balance: $" + this.balance);
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal of $" + amount + " completed. New balance: $" + this.balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Method to transfer funds to another account
    public void transfer(Account destinationAccount, double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Transfer of $" + amount + " completed.");
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}

// Transaction class
class Transaction {
    private String transactionId;
    private double amount;
    private TransactionType type;
    private Date date;
    private Status status;

    public Transaction(String transactionId, double amount, TransactionType type, Date date, Status status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.status = status;
    }

    // Getter methods
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }
}
// BillPayment class
class BillPayment {
    private String billId;
    private double amount;
    private String payee;
    private Date schedule;

    public BillPayment(String billId, double amount, String payee, Date schedule) {
        this.billId = billId;
        this.amount = amount;
        this.payee = payee;
        this.schedule = schedule;
    }

    // Getter methods
    public String getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayee() {
        return payee;
    }

    public Date getSchedule() {
        return schedule;
    }
}

// Role class
class Role {
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    // Getter method
    public String getRoleName() {
        return roleName;
    }
}

// Permission class
class Permission {
    private String permissionName;

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    // Getter method
    public String getPermissionName() {
        return permissionName;
    }
}

// Alert class
class Alert {
    private String alertId;
    private AlertType type;
    private String message;
    private User user;

    public Alert(String alertId, AlertType type, String message, User user) {
        this.alertId = alertId;
        this.type = type;
        this.message = message;
        this.user = user;
    }

    // Getter methods
    public String getAlertId() {
        return alertId;
    }

    public AlertType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}

public class Bank {
    public static void main(String[] args) {
        // Create a user
        User user = new User("john_doe", "password123", "fingerprint");

        // Create a savings account
        Account savingsAccount = new Account("SAV123", 1000.0, AccountType.SAVINGS);

        // Deposit funds into the account
        savingsAccount.deposit(200.0);

        // Withdraw funds from the account
        savingsAccount.withdraw(50.0);

        // Create a checking account
        Account checkingAccount = new Account("CHK456", 500.0, AccountType.CHECKING);

        // Transfer funds between accounts
        savingsAccount.transfer(checkingAccount, 100.0);

        // Create a deposit transaction
        Transaction depositTransaction = new Transaction("TXN001", 500.0, TransactionType.DEPOSIT, new Date(), Status.COMPLETED);

        // Create a bill payment
        BillPayment electricityBill = new BillPayment("BILL001", 50.0, "Electricity Company", new Date());

        // Create a role
        Role adminRole = new Role("Admin");

        // Create a permission
        Permission adminPermission = new Permission("AdminAccess");

        // Create an alert
        Alert lowBalanceAlert = new Alert("ALERT001", AlertType.LOW_BALANCE, "Low balance alert", user);

        // Output some information
        System.out.println("User: " + user.getUsername());
        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
        System.out.println("Checking Account Balance: $" + checkingAccount.getBalance());
        System.out.println("Deposit Transaction Amount: $" + depositTransaction.getAmount());
        System.out.println("Bill Payment Amount: $" + electricityBill.getAmount());
        System.out.println("Admin Role: " + adminRole.getRoleName());
        System.out.println("Admin Permission: " + adminPermission.getPermissionName());
        System.out.println("Low Balance Alert Message: " + lowBalanceAlert.getMessage());
    }
}

