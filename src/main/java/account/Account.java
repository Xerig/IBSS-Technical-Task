package account;

import java.util.ArrayList;

public class Account {
    private final int number;
    private final String name;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private double balance;


    public Account(int number, String name) {
        this.number = number;
        this.name = name;
        this.balance = 0.0;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(String id, double amount) {
        transactions.add(new Transaction(id, amount, TransactionType.WITHDRAWAL));
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            throw new RuntimeException("Withdrawal taking more than remaining in balance.");
        }
    }

    public void deposit(String id, double amount) {
        transactions.add(new Transaction(id, amount, TransactionType.DEPOSIT));
        balance += amount;
    }


    public String statement() {
        StringBuilder statement = new StringBuilder();
        String symbol;
        statement.append(String.format("Name: %s%nAccount: %d%nBalance: %.2f%nTransactions:"
                , getName(), getNumber(), getBalance()));
        for (Transaction transaction : getTransactions()) {
            // Positive and negative signs indicate if the transaction was a
            // withdrawal or a deposit.
            if (transaction.getType() == TransactionType.WITHDRAWAL) {
                symbol = "-";
            } else {
                symbol = "+";
            }
            statement.append(String.format("%n|%s|%s%.2f|",
                    transaction.getId(), symbol, transaction.getAmount()));
        }
        return statement.toString();
    }
}
