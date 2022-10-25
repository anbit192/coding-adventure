package oops.car;

import oops.car.Car;

public class ServiceCar extends Car {

    private double fee;

    public ServiceCar(String id, String name, String manufacturer, double hours, double price, double fee) {
        super(id, name, manufacturer, hours, price);
        this.fee = fee;
    }

    public ServiceCar() {

    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double getAmount() {
        return super.getPrice() * super.getHours() + this.getFee();
    }

    @Override
    public String toString() {

        return String.format("====================\nCar type : Service Car\nID : %s\nName : %s\nManufacturer : %s\nNumber Of Hours : %.1f\n" +
                "Price per Hour : %.1f\nFee : %.1f\nAmount : %.2f\n====================\n", super.getId(), super.getName(), super.getManufacturer(), super.getHours(), super.getPrice(), this.fee, this.getAmount());
    }
}
