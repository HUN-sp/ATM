import java.util.concurrent.TimeUnit;

public class CardReader {
    public Card readCard() {
        System.out.println("\nWelcome! Please insert your card (Press Enter to simulate).");
        // Simulating card insertion with a dummy HDFC card
        System.out.println("Card Inserted. Reading data...");
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return new Card("1111222233334444", "12/28", "John Doe");
        // For testing another bank, you could return this:
        // return new Card("5555666677778888", "10/27", "Jane Smith");
    }
    public void ejectCard() { System.out.println("Card ejected. Please take your card."); }
}

