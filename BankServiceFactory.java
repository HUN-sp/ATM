public class BankServiceFactory {
    public static BankService getBankService(Card card) {
        String bankId = card.getBankId();
        if ("1111".equals(bankId)) {
            return new HDFCBankService();
        } else if ("5555".equals(bankId)) {
            return new ICICIBankService();
        }
        System.out.println("ERROR: This bank is not supported.");
        return null;
    }
}

