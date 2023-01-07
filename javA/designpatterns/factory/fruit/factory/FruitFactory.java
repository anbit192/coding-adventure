package designpatterns.factory.fruit.factory;

import designpatterns.factory.fruit.products.Apple;
import designpatterns.factory.fruit.products.Banana;
import designpatterns.factory.fruit.products.Fruit;
import designpatterns.factory.fruit.products.Orange;

public class FruitFactory {
    public Fruit provideFruitType(String type) {
        if (type.equalsIgnoreCase("apple")) {
            return new Apple();
        } else if (type.equalsIgnoreCase("banana")) {
            return new Banana();
        } else {
            return new Orange();
        }
    }
}
