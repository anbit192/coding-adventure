package designpatterns.abstractfactory.shape;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Rounded square!");
    }
}
