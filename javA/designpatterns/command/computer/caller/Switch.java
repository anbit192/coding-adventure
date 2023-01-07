package designpatterns.command.computer.caller;

import designpatterns.command.computer.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Switch {
    private List<Command> historyCommands;

    public Switch() {
        this.historyCommands = new ArrayList<>();
    }

    public void storeAndExecute(Command command) {
        command.execute();
        historyCommands.add(command);
    }

    public void undo() {
        System.out.println("Undo ");
        this.historyCommands.remove(this.historyCommands.size()-1);
        this.storeAndExecute(this.historyCommands.get(this.historyCommands.size()-1));
    }
}
