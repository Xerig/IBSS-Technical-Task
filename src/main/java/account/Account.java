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

    public void withdraw(String id, double amount) {
        transactions.add(new Transaction(id, amount, TransactionType.WITHDRAWAL));
        // Note: Currently no implemented error checking for negative balances
        balance -= amount;
    }

    public void deposit(String id, double amount) {
        transactions.add(new Transaction(id, amount, TransactionType.DEPOSIT));
        balance += amount;
    }


    public String statement() {
        StringBuilder statement = new StringBuilder();
        String symbol;
        statement.append(String.format("Name: %s%nAccount: %d%nBalance: %.2f%nTransactions:", name, number, balance));
        for (Transaction transaction : transactions) {
            // Positive and negative signs indicate if the transaction was a
            // withdrawal or a deposit.
            if (transaction.getType() == TransactionType.WITHDRAWAL) {
                symbol = "-";
            } else {
                symbol = "+";
            }
            statement.append(String.format("%n|%s|%s%.2f|", transaction.getId(), symbol, transaction.getAmount()));
        }
        return statement.toString();
    }
}
