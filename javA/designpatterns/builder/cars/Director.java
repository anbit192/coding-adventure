package designpatterns.builder.cars;

public class Director {

    public void makeSUV(Builder builder) {
        builder.reset();
        builder.setSeats(4);
        builder.setEngine("SUV Engine");
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    public void makeSportCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine("Sport Engine");
        builder.setTripComputer(false);
        builder.setGPS(true);
    }
}
