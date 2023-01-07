package designpatterns.command.computer;

import designpatterns.command.computer.caller.Switch;
import designpatterns.command.computer.commands.RestartCommand;
import designpatterns.command.computer.commands.ShutDownCommand;
import designpatterns.command.computer.receiver.Computer;

public class TestCommand {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Switch mySwitch = new Switch();

        RestartCommand restart = new RestartCommand(computer);
        ShutDownCommand shutdown = new ShutDownCommand(computer);

        mySwitch.storeAndExecute(restart);
        mySwitch.storeAndExecute(shutdown);

        mySwitch.undo();


    }
}
