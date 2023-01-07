package designpatterns.factory.dialog.product;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendered a button in window style!");
    }

    @Override
    public void onClick() {
        System.out.println("Clicked!");
    }
}
