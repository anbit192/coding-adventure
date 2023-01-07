package designpatterns.factory.dialog.factory;

import designpatterns.factory.dialog.product.Button;
import designpatterns.factory.dialog.product.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
