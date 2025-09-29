import java.util.HashMap;
import java.util.Map;

public class HDFCBankService implements BankService {
    private final Map<String, String> userPins = new HashMap<>();
    private final Map<String, BankAccount> userAccounts = new HashMap<>();

    public HDFCBankService() {
        // Dummy data for HDFC Bank (Cards starting with 1111)
        userPins.put("1111222233334444", "1234");
        userAccounts.put("1111222233334444", new BankAccount("HDFC001", 5000.0));
    }

    @Override
    public User authenticate(String cardNumber, String pin) {
        if (userPins.containsKey(cardNumber) && userPins.get(cardNumber).equals(pin)) {
            Card card = new Card(cardNumber, "12/28", "John Doe");
            BankAccount account = userAccounts.get(cardNumber);
            return new User(card, account);
        }
        return null;
    }

    @Override
    public void executeTransaction(Transaction transaction) {
        BankAccount account = transaction.user.getBankAccount();
        if (transaction instanceof CashWithdrawal) {
            CashWithdrawal cw = (CashWithdrawal) transaction;
            if (account.getBalance() >= cw.getAmount()) {
                account.debit(cw.getAmount());
                transaction.status = TransactionStatus.SUCCESS;
                System.out.println("BANK(HDFC): Withdrawal approved.");
            } else {
                transaction.status = TransactionStatus.FAILURE;
                System.out.println("BANK(HDFC): Insufficient funds.");
            }
        } else if (transaction instanceof BalanceInquiry) {
            System.out.println("BANK(HDFC): Current Balance is $" + account.getBalance());
            transaction.status = TransactionStatus.SUCCESS;
        } else if (transaction instanceof Deposit) {
            Deposit d = (Deposit) transaction;
            account.credit(d.getAmount());
            transaction.status = TransactionStatus.SUCCESS;
            System.out.println("BANK(HDFC): Deposit successful. New balance: $" + account.getBalance());
        }
    }
}

