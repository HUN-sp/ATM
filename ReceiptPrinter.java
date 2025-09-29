public class ReceiptPrinter {
    public void printReceipt(Transaction transaction) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.println("Date: " + transaction.getCreationDate());
        System.out.println("Status: " + transaction.getStatus());
        System.out.println("-----------------\n");
    }
}





