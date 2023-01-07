package designpatterns.decorator.shape.decorators;

import designpatterns.decorator.shape.components.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw() {
        System.out.print("red ");
        shape.draw();
    }
}
