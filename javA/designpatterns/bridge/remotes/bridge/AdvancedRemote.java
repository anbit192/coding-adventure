package designpatterns.bridge.remotes.bridge;

import designpatterns.bridge.remotes.Device;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        this.device.setVolume(0);
    }
}
