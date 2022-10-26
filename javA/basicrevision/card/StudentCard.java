package basicrevision.card;

public class StudentCard extends Card {

    private double fee;

    public StudentCard(String id, int year, double days, double price, double fee) {
        super(id, year, days, price);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double getAmount() {
        return super.getAmount() + this.getFee();
    }

    @Override
    public String toString() {
        return "StudentCard [fee=" + fee + ", getFee()=" + getFee() + ", getId()="
                + getId() + ", getYear()=" + getYear() + ", getDays()=" + getDays() + ", getPrice()=" + getPrice();
    }

}
