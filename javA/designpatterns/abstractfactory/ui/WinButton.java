package designpatterns.abstractfactory.ui;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Window button created!");
    }
}
