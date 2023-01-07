package designpatterns.command.computer.receiver;

public class Computer {

    public void shutdown() {
        System.out.println("Shutdown!");
    }

    public void restart() {
        System.out.println("Restart!");
    }
}
