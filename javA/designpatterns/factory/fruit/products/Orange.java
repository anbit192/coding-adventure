package designpatterns.factory.fruit.products;

public class Orange implements Fruit {
    @Override
    public void produceJuice() {
        System.out.println("Orange juice!");
    }
}
