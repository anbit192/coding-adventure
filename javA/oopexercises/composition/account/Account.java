package oopexercises.composition.account;

public class Account {
    private int id;
    private Customer customer;
    private double balance;

    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.balance = 0.0;
    }

    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s balance = $%.2f", this.getCustomer().toString(), this.getBalance());
    }

    public String getCustomerName() {
        return this.getCustomer().getName();
    }

    public Account deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        return this;
    }

    public Account withdraw(double amount) {
        if (this.getBalance() >= amount) {
            this.setBalance(this.getBalance()-amount);
        }
        else {
            System.out.println("Not enough money!");
        }
        return this;
    }
}
