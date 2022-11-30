package designpatterns.abstractfactory.ui;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Mac checkbox created!");
    }
}
