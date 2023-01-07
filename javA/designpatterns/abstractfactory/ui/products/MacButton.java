package designpatterns.abstractfactory.ui.products;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button created!");
    }
}
