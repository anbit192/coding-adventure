package designpatterns.abstractfactory.shape.factories;

public class FactoryProducer {
    public AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("Rounded")) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
