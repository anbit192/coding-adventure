package designpatterns.command.computer.commands;

import designpatterns.command.computer.receiver.Computer;

public class RestartCommand implements Command {
    private Computer computer;

    public RestartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        this.computer.restart();
    }
}
