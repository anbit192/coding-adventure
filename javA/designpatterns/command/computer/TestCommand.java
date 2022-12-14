package designpatterns.command.computer;

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
