package designpatterns.abstractfactory.shape;

import designpatterns.abstractfactory.shape.factories.AbstractFactory;
import designpatterns.abstractfactory.shape.factories.FactoryProducer;
import designpatterns.abstractfactory.shape.products.Shape;

public class App {
    public static void main(String[] args) {
        FactoryProducer producer = new FactoryProducer();
        AbstractFactory factory = producer.getFactory("rounded");

        Shape roundedRectangle = factory.getShape("rectangle");

        roundedRectangle.draw();

    }
}
