package Practice1;
public class BankAccount {

    // Properties
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Default constructor
    public BankAccount() {
        this.balance = 0.0;
    }

    // Constructor with accountNumber and accountHolder
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Constructor with all properties
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Display balance method
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Main method to test the class
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC1001", "Purity Waithera", 1000.0);

        account.displayBalance();
        account.deposit(500);
        account.withdraw(300);
        account.displayBalance();
    }
}

    

