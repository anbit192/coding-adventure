package oops.car;

import oops.car.Car;

public class SportCar extends Car {
    
    private double tax;

    public SportCar(String id, String name, String manufacturer, double hours, double price, double tax) {

        super(id, name, manufacturer, hours, price);
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

        return (super.getPrice() * super.getHours()) + (super.getPrice() * super.getHours() * (this.getTax()/100.0));
    }

    @Override
    public String toString() {

        return String.format("====================\nCar type : Sport Car\nID : %s\nName : %s\nManufacturer : %s\nNumber Of Hours : %.1f\n" +
                "Price per Hour : %.1f\nTax : %.1f\nAmount : %.2f\n====================\n", super.getId(), super.getName(), super.getManufacturer(), super.getHours(), super.getPrice(), this.tax, this.getAmount());
    }

    
}
