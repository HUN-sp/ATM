public class Deposit extends Transaction {
    private final double amount;
    public Deposit(User user, BankService bankService, double amount) {
        super(user, bankService);
        this.amount = amount;
    }

    @Override
    public void execute() {
        bankService.executeTransaction(this);
    }
    public double getAmount() { return amount; }
}

