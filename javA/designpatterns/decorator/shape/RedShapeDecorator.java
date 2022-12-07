package designpatterns.decorator.shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw() {
        System.out.print("red ");
        shape.draw();
    }
}
