package oopexercises.classesandobjects.account;

public class Account {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int credit(int amount) {
        this.setBalance(this.getBalance() + amount);
        return this.getBalance();
    }

    public int debit(int amount) {
        if (amount <= this.getBalance()) {
            this.setBalance(this.getBalance() - amount);
        }
        else {
            System.out.println("Not enough money!");
        }

        return this.getBalance();
    }

    public int transfer(Account other, int amount) {
        if (this.getBalance() >= amount) {
            other.setBalance(other.getBalance() + amount);
            this.setBalance(this.getBalance() - amount);
        }
        else {
            System.out.println("Not enough money!");
        }

        return this.getBalance();
    }

    @Override
    public String toString() {
        return String.format("Account[id = %s, name = %s, balance = %d]", this.getId(), this.getName(), this.getBalance());
    }
}
