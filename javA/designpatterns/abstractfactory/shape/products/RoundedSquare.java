package designpatterns.abstractfactory.shape.products;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Rounded square!");
    }
}
