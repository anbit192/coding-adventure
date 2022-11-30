package designpatterns.abstractfactory.shape;

public class App {
    public static void main(String[] args) {
        FactoryProducer producer = new FactoryProducer();
        AbstractFactory factory = producer.getFactory("rounded");

        Shape roundedRectangle = factory.getShape("rectangle");

        roundedRectangle.draw();

    }
}
