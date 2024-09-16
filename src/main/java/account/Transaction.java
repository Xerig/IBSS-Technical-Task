package account;

public class Transaction {
    private final String id;
    private final double amount;
    private final TransactionType type;

    public Transaction(String id, double amount, TransactionType type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
}
