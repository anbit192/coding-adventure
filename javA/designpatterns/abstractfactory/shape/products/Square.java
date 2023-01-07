package designpatterns.abstractfactory.shape.products;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square!");
    }
}
