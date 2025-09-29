public class BalanceInquiry extends Transaction {
    public BalanceInquiry(User user, BankService bankService) { super(user, bankService); }
    @Override
    public void execute() {
        bankService.executeTransaction(this);
    }
}

