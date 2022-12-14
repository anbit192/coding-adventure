package designpatterns.command.text;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<Command> history;

    public CommandHistory() {
        history = new ArrayList<>();
    }

    public void push(Command command) {
        history.add(command);
    }

    public Command pop() {
        return history.get(history.size() - 1);
    }
}
