package designpatterns.abstractfactory.ui.factories;

import designpatterns.abstractfactory.ui.products.Button;
import designpatterns.abstractfactory.ui.products.Checkbox;

public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
