package designpatterns.abstractfactory.ui.factories;

import designpatterns.abstractfactory.ui.products.Button;
import designpatterns.abstractfactory.ui.products.Checkbox;
import designpatterns.abstractfactory.ui.products.MacButton;
import designpatterns.abstractfactory.ui.products.MacCheckbox;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
