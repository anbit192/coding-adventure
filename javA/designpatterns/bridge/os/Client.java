package designpatterns.bridge.os;

import designpatterns.bridge.os.bridge.MacOs;
import designpatterns.bridge.os.bridge.OperatingSystem;
import designpatterns.bridge.os.bridge.WindowOs;

public class Client {
    public static void main(String[] args) {
        OperatingSystem window = new WindowOs();
        OperatingSystem mac = new MacOs();

        Computer pc = new Pc(window);
        Computer laptop = new Laptop(mac);

        pc.startUp();
        laptop.startUp();
    }
}
