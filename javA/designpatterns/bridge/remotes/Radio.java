package designpatterns.bridge.remotes;

public class Radio implements Device {

    private boolean status;
    private int volume;
    private int currentChannel;

    public Radio(boolean status, int volume, int currentChannel) {
        this.status = status;
        this.volume = volume;
        this.currentChannel = currentChannel;
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }

    @Override
    public void enable() {
        this.status = true;
    }

    @Override
    public void disable() {
        this.status = false;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
    }

    @Override
    public int getChannel() {
        return this.currentChannel;
    }

    @Override
    public void setChannel(int channel) {
        this.currentChannel = channel;
    }

    @Override
    public String toString() {
        return "Radio[" +
                "status=" + status +
                ", volume=" + volume +
                ", currentChannel=" + currentChannel +
                ']';
    }
}
