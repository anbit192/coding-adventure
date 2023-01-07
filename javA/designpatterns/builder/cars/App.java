package designpatterns.builder.cars;

import designpatterns.builder.cars.builders.CarBuilder;
import designpatterns.builder.cars.builders.CarManualBuilder;
import designpatterns.builder.cars.product.Car;
import designpatterns.builder.cars.product.Director;
import designpatterns.builder.cars.product.Manual;

public class App {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.makeSUV(builder);
        Car car1 = builder.getResult();
        director.makeSportCar(builder);
        Car car2 = builder.getResult();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.makeSUV(manualBuilder);

        Manual manualCar1 = manualBuilder.getResult();
        director.makeSportCar(manualBuilder);

        Manual manualCar2 = manualBuilder.getResult();

        System.out.println(car1);
        System.out.println(manualCar1);


        System.out.println(car2);
        System.out.println(manualCar2);

    }
}
