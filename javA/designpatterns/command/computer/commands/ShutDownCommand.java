package designpatterns.command.computer.commands;

import designpatterns.command.computer.receiver.Computer;

public class ShutDownCommand implements Command {
    private Computer computer;

    public ShutDownCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        this.computer.shutdown();
    }
}
