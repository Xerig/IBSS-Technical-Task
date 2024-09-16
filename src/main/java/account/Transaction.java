package account;

public class Transaction {
    private final String id;
    private final int amount;
    private final TransactionType type;

    public Transaction(String id, int amount, TransactionType type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
}
