public class User {
    private final Card card;
    private final BankAccount bankAccount;

    public User(Card card, BankAccount bankAccount) {
        this.card = card;
        this.bankAccount = bankAccount;
    }
    public Card getCard() { return card; }
    public BankAccount getBankAccount() { return bankAccount; }
}

