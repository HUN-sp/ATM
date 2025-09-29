public class Card {
    private final String cardNumber;
    private final String expiryDate;
    private final String cardHolderName;

    public Card(String cardNumber, String expiryDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() { return cardNumber; }

    
    public String getBankId() {
        if (cardNumber != null && cardNumber.length() > 4) {
            return cardNumber.substring(0, 4);
        }
        return null;
    }
}

