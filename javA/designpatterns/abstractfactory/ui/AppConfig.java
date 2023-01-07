package designpatterns.abstractfactory.ui;

import designpatterns.abstractfactory.ui.factories.GUIFactory;
import designpatterns.abstractfactory.ui.factories.MacFactory;
import designpatterns.abstractfactory.ui.factories.WinFactory;

public class AppConfig {
    public static void main(String[] args) {
        String config = System.getProperty("os.name").toLowerCase();
        System.out.println(config);
        GUIFactory factory;

        if (config.contains("win")) {
            factory = new WinFactory();
        } else if (config.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);

        app.createUI();
        app.paint();
    }
}
