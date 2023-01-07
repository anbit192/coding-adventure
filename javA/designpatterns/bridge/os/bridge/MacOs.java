package designpatterns.bridge.os.bridge;

public class MacOs implements OperatingSystem {
    @Override
    public void startup() {
        System.out.println("Starting Mac OS...");
    }

    @Override
    public void loadUrl(String url) {
        System.out.println("Loading " + url);

    }
}
