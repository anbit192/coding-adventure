package designpatterns.abstractfactory.ui.products;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Window button created!");
    }
}
