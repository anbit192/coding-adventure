package designpatterns.decorator.icecream;

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
