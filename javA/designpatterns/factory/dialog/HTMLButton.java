package designpatterns.factory.dialog;

public class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendered button in HTML style!");
    }

    @Override
    public void onClick() {
        System.out.println("Clicked!");
    }
}
