package designpatterns.factory.dialog.factory;

import designpatterns.factory.dialog.product.Button;

public abstract class Dialog {
    public abstract Button createButton();

    public void render() {
        Button okButton = createButton();

        okButton.onClick();
        okButton.render();
    }
}
