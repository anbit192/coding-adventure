package designpatterns.bridge.os;

import designpatterns.bridge.os.bridge.OperatingSystem;

public abstract class Computer {

    protected OperatingSystem os;

    public Computer(OperatingSystem os) {
        this.os = os;
    }

    public abstract void startUp();

    public abstract void browseInternet(String url);

    public abstract boolean canMoveComputer();


}
