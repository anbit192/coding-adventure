package designpatterns.decorator.icecream.decorators;

import designpatterns.decorator.icecream.components.IceCream;

public abstract class ToppingDecorator implements IceCream {
    private IceCream iceCream;

    public ToppingDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription();
    }

    public abstract String addTopping();

}
