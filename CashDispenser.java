public class CashDispenser {
    private double availableCash = 50000.0;
    public boolean hasSufficientCash(double amount) { return availableCash >= amount; }
    public void dispenseCash(double amount) {
        if (hasSufficientCash(amount)) {
            availableCash -= amount;
            System.out.println("SUCCESS: Dispensing $" + amount + ". Please collect your cash.");
        }
    }
}

