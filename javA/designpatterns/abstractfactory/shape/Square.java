package designpatterns.abstractfactory.shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square!");
    }
}
