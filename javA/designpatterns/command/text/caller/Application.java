package designpatterns.command.text.caller;

import designpatterns.command.text.commands.Command;
import designpatterns.command.text.commands.CommandHistory;
import designpatterns.command.text.receiver.Editor;

import java.util.List;

public class Application {
    public String clipboard;
    public List<Editor> editors;
    public Editor activeEditor;
    public CommandHistory history;

    public Application(CommandHistory history) {
        this.history = history;
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
