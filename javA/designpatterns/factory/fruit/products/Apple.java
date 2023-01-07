package designpatterns.factory.fruit.products;

public class Apple implements Fruit {


    @Override
    public void produceJuice() {
        System.out.println("Apple juice!");
    }
}
