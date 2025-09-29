import java.util.concurrent.TimeUnit;

public class ATM {
    private final String atmId;
    private final String location;
    private final Screen screen;
    private final CardReader cardReader;
    private final Keypad keypad;
    private final CashDispenser cashDispenser;
    private final DepositSlot depositSlot;
    private final ReceiptPrinter receiptPrinter;

    public ATM(String atmId, String location) {
        this.atmId = atmId;
        this.location = location;
        this.screen = new Screen();
        this.cardReader = new CardReader();
        this.keypad = new Keypad();
        this.cashDispenser = new CashDispenser();
        this.depositSlot = new DepositSlot();
        this.receiptPrinter = new ReceiptPrinter();
    }

    // Getters needed by the TransactionFactory to access hardware
    public Screen getScreen() { return screen; }
    public Keypad getKeypad() { return keypad; }
    public CashDispenser getCashDispenser() { return cashDispenser; }
    public DepositSlot getDepositSlot() { return depositSlot; }
    
    public void run() {
        while (true) {
            Card card = cardReader.readCard();
            
            BankService bankService = BankServiceFactory.getBankService(card);
            if (bankService == null) {
                endSession();
                continue;
            }

            screen.displayMessage("Please enter your PIN:");
            String pin = keypad.getInput();
            User user = bankService.authenticate(card.getCardNumber(), pin);

            if (user == null) {
                screen.displayMessage("Authentication failed. Please try again.");
                endSession();
                continue;
            }

            screen.displayMessage("Authentication successful. Welcome!");
            
            boolean inSession = true;
            while (inSession) {
                String[] options = {"Cash Withdrawal", "Balance Inquiry", "Deposit", "Exit"};
                screen.displayOptions(options);
                String choice = keypad.getInput();

                Transaction transaction = null;
                switch (choice) {
                    case "1":
                        transaction = TransactionFactory.createTransaction(TransactionType.CASH_WITHDRAWAL, user, bankService, this);
                        break;
                    case "2":
                        transaction = TransactionFactory.createTransaction(TransactionType.BALANCE_INQUIRY, user, bankService, this);
                        break;
                    case "3":
                        transaction = TransactionFactory.createTransaction(TransactionType.DEPOSIT, user, bankService, this);
                        break;
                    case "4":
                        inSession = false;
                        continue;
                    default:
                        screen.displayMessage("Invalid option. Please try again.");
                }

                if (transaction != null) {
                    transaction.execute();
                    receiptPrinter.printReceipt(transaction);
                }
                
                screen.displayMessage("Do you want to perform another transaction? (yes/no)");
                if (!keypad.getInput().equalsIgnoreCase("yes")) {
                    inSession = false;
                }
            }
            endSession();
        }
    }

    private void endSession() {
        cardReader.ejectCard();
        screen.displayMessage("Thank you for using our ATM. Goodbye!");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        System.out.println("\n=======================================\n");
    }
}


// =================================================================================
// SECTION: Main Entry Point
// =================================================================================

