package designpatterns.builder.cars.builders;

import designpatterns.builder.cars.product.Car;

public class CarBuilder implements Builder {

    private Car car;

    public CarBuilder() {
        this.reset();
    }

    @Override
    public Builder reset() {
        this.car = new Car();
        return this;
    }

    @Override
    public Builder setSeats(int number) {
        this.car.setSeats(number);
        return this;
    }

    @Override
    public Builder setEngine(String engine) {
        this.car.setEngine(engine);
        return this;
    }

    @Override
    public Builder setTripComputer(boolean bool) {
        this.car.setTripComputer(bool);
        return this;
    }

    @Override
    public Builder setGPS(boolean bool) {
        this.car.setGPS(bool);
        return this;
    }

    public Car getResult() {
        return this.car;
    }
}
