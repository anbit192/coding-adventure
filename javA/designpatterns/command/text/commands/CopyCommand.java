package designpatterns.command.text.commands;

import designpatterns.command.text.receiver.Editor;
import designpatterns.command.text.caller.Application;

public class CopyCommand extends Command {

    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        app.clipboard = editor.getSelection();
    }
}
