package designpatterns.abstractfactory.shape;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            return new Square();
        }
    }
}
