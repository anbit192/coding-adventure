package designpatterns.factory.fruit;

public class Apple implements Fruit {


    @Override
    public void produceJuice() {
        System.out.println("Apple juice!");
    }
}
