package oopexercises.composition.invoice;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerID() {
        return this.getCustomer().getId();
    }

    public String getCustomerName() {
        return this.getCustomer().getName();
    }

    public int getCustomerDiscount() {
        return this.getCustomer().getDiscount();
    }

    public double getAmountAfterDiscount() {
        return this.getAmount() - ((this.getAmount() * this.getCustomerDiscount()) /100);
    }

    @Override
    public String toString() {
        return String.format("Invoice[id = %d, %s, amount = %.2f]", this.getId(), this.getCustomer().toString(), this.getAmount());
    }
}
