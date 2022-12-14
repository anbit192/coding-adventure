package designpatterns.bridge.remotes;

public class Client {
    public static void main(String[] args) {
        Device tv = new Tv(false, 50, 1);
        Remote remote = new Remote(tv);

        remote.togglePower();
        remote.volumeDown();
        remote.channelUp();

        System.out.println(tv);

        Device radio = new Radio(true, 20, 3);
        Remote remoteControl = new AdvancedRemote(radio);
        remoteControl.channelUp();

        ((AdvancedRemote) remoteControl).mute();

        System.out.println(radio);
    }
}
