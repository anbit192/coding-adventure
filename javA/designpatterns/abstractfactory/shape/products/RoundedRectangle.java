package designpatterns.abstractfactory.shape.products;

public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rounded Rectangle");
    }
}
