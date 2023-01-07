package designpatterns.decorator.icecream;

import designpatterns.decorator.icecream.components.ChocolateIceCream;
import designpatterns.decorator.icecream.components.IceCream;
import designpatterns.decorator.icecream.decorators.HoneyToppingDecorator;
import designpatterns.decorator.icecream.decorators.NutsToppingDecorator;

public class App {
    public static void main(String[] args) {
        IceCream iceCream1 = new ChocolateIceCream();
        IceCream fullTopping = new HoneyToppingDecorator(new NutsToppingDecorator(iceCream1));

        System.out.println(fullTopping.getDescription());
    }
}
