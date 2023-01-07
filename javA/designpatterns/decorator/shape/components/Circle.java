package designpatterns.decorator.shape.components;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
