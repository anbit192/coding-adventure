package designpatterns.abstractfactory.shape.factories;

import designpatterns.abstractfactory.shape.products.Rectangle;
import designpatterns.abstractfactory.shape.products.Shape;
import designpatterns.abstractfactory.shape.products.Square;

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
