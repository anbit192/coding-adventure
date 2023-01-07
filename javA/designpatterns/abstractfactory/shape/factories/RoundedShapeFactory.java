package designpatterns.abstractfactory.shape.factories;

import designpatterns.abstractfactory.shape.products.RoundedRectangle;
import designpatterns.abstractfactory.shape.products.RoundedSquare;
import designpatterns.abstractfactory.shape.products.Shape;

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
