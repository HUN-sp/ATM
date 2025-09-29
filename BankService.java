public interface BankService {
    User authenticate(String cardNumber, String pin);
    void executeTransaction(Transaction transaction);
}

