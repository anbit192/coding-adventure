package designpatterns.decorator.icecream.decorators;

import designpatterns.decorator.icecream.components.IceCream;

public class NutsToppingDecorator extends ToppingDecorator {

    public NutsToppingDecorator(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + addTopping();
    }
    @Override
    public String addTopping() {
        return " + nuts topping";
    }
}
