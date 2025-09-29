public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public void debit(double amount) { this.balance -= amount; }
    public void credit(double amount) { this.balance += amount; }
}


