package designpatterns.decorator.shape;

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
