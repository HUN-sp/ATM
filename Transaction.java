import java.sql.Date;
import java.util.UUID;

public abstract class Transaction {
    protected final String transactionId;
    protected TransactionStatus status;
    protected final Date creationDate;
    protected final User user;
    protected final BankService bankService;

    public Transaction(User user, BankService bankService) {
        this.transactionId = UUID.randomUUID().toString();
        this.status = TransactionStatus.PENDING;
        this.creationDate = new Date(0);
        this.user = user;
        this.bankService = bankService;
    }

    public String getTransactionId() { return transactionId; }
    public TransactionStatus getStatus() { return status; }
    public Date getCreationDate() { return creationDate; }

    public abstract void execute();
}