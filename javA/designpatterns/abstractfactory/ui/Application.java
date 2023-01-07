package designpatterns.abstractfactory.ui;

import designpatterns.abstractfactory.ui.factories.GUIFactory;
import designpatterns.abstractfactory.ui.products.Button;
import designpatterns.abstractfactory.ui.products.Checkbox;

public class Application {
    private GUIFactory factory;
    private Button button;

    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        this.button.paint();
        this.checkbox.paint();
    }


}
