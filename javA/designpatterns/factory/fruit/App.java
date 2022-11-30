package designpatterns.factory.fruit;

public class App {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        Fruit apple = factory.provideFruitType("apple");
        Fruit banana = factory.provideFruitType("banana");

        apple.produceJuice();
        banana.produceJuice();

    }

}
