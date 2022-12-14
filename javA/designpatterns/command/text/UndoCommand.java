package designpatterns.command.text;

public class UndoCommand extends Command {

    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        this.app.undo();
    }
}
