package designpatterns.command.text;

public class CutCommand extends Command {

    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        this.saveBackup();
        this.app.clipboard = this.editor.getSelection();
        this.editor.deleteSelection();
    }
}
