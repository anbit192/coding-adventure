package designpatterns.abstractfactory.ui.factories;

import designpatterns.abstractfactory.ui.products.Button;
import designpatterns.abstractfactory.ui.products.Checkbox;
import designpatterns.abstractfactory.ui.products.WinButton;
import designpatterns.abstractfactory.ui.products.WinCheckbox;

public class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
