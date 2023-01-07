package designpatterns.decorator.shape;

import designpatterns.decorator.shape.components.Circle;
import designpatterns.decorator.shape.components.Rectangle;
import designpatterns.decorator.shape.components.Shape;
import designpatterns.decorator.shape.decorators.RedShapeDecorator;

public class App {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Shape redCircle = new RedShapeDecorator(circle);
        Shape redRectangle = new RedShapeDecorator(rectangle);

        circle.draw();
        redCircle.draw();

        redRectangle.draw();
    }
}
