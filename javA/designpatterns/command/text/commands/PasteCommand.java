package designpatterns.command.text.commands;

import designpatterns.command.text.receiver.Editor;
import designpatterns.command.text.caller.Application;

public class PasteCommand extends Command {

    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        this.saveBackup();
        this.editor.replaceSelection(this.app.clipboard);
        this.editor.text += this.editor.getSelection();
    }
}
