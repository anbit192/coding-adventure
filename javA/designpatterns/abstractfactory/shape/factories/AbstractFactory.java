package designpatterns.abstractfactory.shape.factories;

import designpatterns.abstractfactory.shape.products.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String type);
}
