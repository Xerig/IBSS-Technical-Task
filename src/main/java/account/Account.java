package account;

public class Account {
    private final int number;
    private final String name;

    public Account(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
