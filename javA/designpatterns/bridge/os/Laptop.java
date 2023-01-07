package designpatterns.bridge.os;

import designpatterns.bridge.os.bridge.OperatingSystem;

public class Laptop extends Computer {
    public Laptop(OperatingSystem os) {
        super(os);
    }

    @Override
    public void startUp() {
        this.os.startup();
    }

    @Override
    public void browseInternet(String url) {
        this.os.loadUrl(url);
    }

    @Override
    public boolean canMoveComputer() {
        return true;
    }
}
