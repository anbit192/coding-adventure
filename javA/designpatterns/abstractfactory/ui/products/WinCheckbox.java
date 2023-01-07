package designpatterns.abstractfactory.ui.products;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Window Checkbox created!");
    }
}
