package designpatterns.bridge.os;

public class WindowOs implements OperatingSystem {
    @Override
    public void startup() {
        System.out.println("Starting Window OS...");
    }

    @Override
    public void loadUrl(String url) {
        System.out.println("Loading " + url);
    }
}
