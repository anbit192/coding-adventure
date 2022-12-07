package designpatterns.decorator.icecream;

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
