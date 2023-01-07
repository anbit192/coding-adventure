package designpatterns.decorator.shape.decorators;

import designpatterns.decorator.shape.components.Shape;

public abstract class ShapeDecorator implements Shape {

    public Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }
}
