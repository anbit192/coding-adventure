package designpatterns.factory.dialog.factory;

import designpatterns.factory.dialog.product.Button;
import designpatterns.factory.dialog.product.HTMLButton;

public class WebDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
