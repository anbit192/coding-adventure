package designpatterns.abstractfactory.ui;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button created!");
    }
}
