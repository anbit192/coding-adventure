package designpatterns.factory.dialog;

import designpatterns.factory.dialog.factory.Dialog;
import designpatterns.factory.dialog.factory.WebDialog;
import designpatterns.factory.dialog.factory.WindowsDialog;

public class App {
    private static Dialog dialog;

    public void init() {
        String config = System.getProperty("os.name").toLowerCase();

        if (config.contains("win")) {
            dialog = new WindowsDialog();
        } else if (config.contains("web")) {
            dialog = new WebDialog();
        } else {
            dialog = new WindowsDialog();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.init();
        dialog.render();

    }
}
