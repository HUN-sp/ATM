public class CashWithdrawal extends Transaction {
    private final double amount;
    private final CashDispenser cashDispenser;

    public CashWithdrawal(User user, BankService bankService, double amount, CashDispenser cashDispenser) {
        super(user, bankService);
        this.amount = amount;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        if (!cashDispenser.hasSufficientCash(amount)) {
            System.out.println("ERROR: ATM out of cash. Please try a smaller amount.");
            this.status = TransactionStatus.FAILURE;
            return;
        }
        // The bank service is responsible for updating the transaction status and account balance
        bankService.executeTransaction(this);
        if (this.status == TransactionStatus.SUCCESS) {
            cashDispenser.dispenseCash(amount);
        }
    }
    public double getAmount() { return amount; }
}

