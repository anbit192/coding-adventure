package designpatterns.abstractfactory.ui.products;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Mac checkbox created!");
    }
}
