public class TransactionFactory {
    public static Transaction createTransaction(TransactionType type, User user, BankService bankService, ATM atm) {
        switch (type) {
            case CASH_WITHDRAWAL:
                atm.getScreen().displayMessage("Enter amount to withdraw:");
                try {
                    double amount = Double.parseDouble(atm.getKeypad().getInput());
                    return new CashWithdrawal(user, bankService, amount, atm.getCashDispenser());
                } catch (NumberFormatException e) {
                    atm.getScreen().displayMessage("Invalid amount.");
                    return null;
                }
            case BALANCE_INQUIRY:
                return new BalanceInquiry(user, bankService);
            case DEPOSIT:
                double depositAmount = atm.getDepositSlot().receiveDeposit();
                return new Deposit(user, bankService, depositAmount);
            default:
                atm.getScreen().displayMessage("Invalid transaction type.");
                return null;
        }
    }
}




