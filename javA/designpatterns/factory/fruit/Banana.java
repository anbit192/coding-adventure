package designpatterns.factory.fruit;

public class Banana implements Fruit {
    @Override
    public void produceJuice() {
        System.out.println("Banana juice!");
    }
}
