import java.util.HashMap;
import java.util.Map;

public class ICICIBankService implements BankService {
    // A similar mock implementation for another bank
    private final Map<String, String> userPins = new HashMap<>();
    private final Map<String, BankAccount> userAccounts = new HashMap<>();

    public ICICIBankService() {
        userPins.put("5555666677778888", "9876");
        userAccounts.put("5555666677778888", new BankAccount("ICICI001", 10000.0));
    }
    
    @Override
    public User authenticate(String cardNumber, String pin) {
        if (userPins.containsKey(cardNumber) && userPins.get(cardNumber).equals(pin)) {
            Card card = new Card(cardNumber, "10/27", "Jane Smith");
            return new User(card, userAccounts.get(cardNumber));
        }
        return null;
    }

    @Override
    public void executeTransaction(Transaction transaction) {
        System.out.println("BANK(ICICI): Transaction processing...");
        transaction.status = TransactionStatus.SUCCESS; // Simplified for brevity
    }
}

