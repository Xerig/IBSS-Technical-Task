package account;

import java.util.ArrayList;

public class Account {
    private final int number;
    private final String name;
    private int balance;
    private ArrayList<Transaction> transactions;

    public Account(int number, String name) {
        this.number = number;
        this.name = name;
        this.balance = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
