import java.util.concurrent.TimeUnit;

public class DepositSlot {
    public double receiveDeposit() {
        System.out.println("Please insert your cash deposit (simulating deposit of $100).");
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        double amount = 100.0; // Dummy deposited amount for simulation
        System.out.println("DEPOSIT: $" + amount + " detected and received.");
        return amount;
    }
}

