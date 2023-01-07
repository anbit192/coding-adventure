package designpatterns.abstractfactory.shape.products;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle!");
    }
}
