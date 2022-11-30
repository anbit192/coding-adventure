package designpatterns.abstractfactory.ui;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Window Checkbox created!");
    }
}
