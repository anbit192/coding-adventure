package designpatterns.factory.fruit;

import designpatterns.factory.fruit.factory.FruitFactory;
import designpatterns.factory.fruit.products.Fruit;

public class App {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        Fruit apple = factory.provideFruitType("apple");
        Fruit banana = factory.provideFruitType("banana");

        apple.produceJuice();
        banana.produceJuice();

    }

}
