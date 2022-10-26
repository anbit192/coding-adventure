package basicrevision.card;

public class StaffCard extends Card {

    private double tax;

    public StaffCard(String id, int year, double days, double price, double tax) {
        super(id, year, days, price);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public double getAmount() {
        return super.getAmount() + super.getAmount() * this.getTax()/100.0;
    }

    @Override
    public String toString() {
        return "StaffCard [tax=" + tax + ", getTax()=" + getTax() + ", getId()="
                + getId() + ", getYear()=" + getYear() + ", getDays()=" + getDays() + ", getPrice()=" + getPrice()
                + "]";
    }
}
