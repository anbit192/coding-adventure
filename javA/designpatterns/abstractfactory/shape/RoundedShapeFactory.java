package designpatterns.abstractfactory.shape;

public class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("rectangle")) {
            return new RoundedRectangle();
        } else {
            return new RoundedSquare();
        }
    }
}
