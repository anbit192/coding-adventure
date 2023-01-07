package designpatterns.bridge.remotes.bridge;

import designpatterns.bridge.remotes.Device;

public class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (!this.device.isEnabled()) {
            this.device.disable();
        } else {
            this.device.enable();
        }
     }

    public void volumeDown() {
        this.device.setVolume(this.device.getVolume() - 10);
    }

    public void volumeUp() {
        this.device.setVolume(this.device.getVolume() + 10);

    }

    public void channelDown() {
        this.device.setChannel(this.device.getChannel() - 1);
    }

    public void channelUp() {
        this.device.setChannel(this.device.getChannel() + 1);

    }


}
