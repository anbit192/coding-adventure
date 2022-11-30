package designpatterns.factory.fruit;

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
