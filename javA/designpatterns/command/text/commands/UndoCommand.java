package designpatterns.command.text.commands;

import designpatterns.command.text.receiver.Editor;
import designpatterns.command.text.caller.Application;

public class UndoCommand extends Command {

    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        this.app.undo();
    }
}
