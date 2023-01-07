package designpatterns.command.text;

import designpatterns.command.text.caller.Application;
import designpatterns.command.text.commands.*;
import designpatterns.command.text.receiver.Editor;

public class Test {
    public static void main(String[] args) {
        Editor editor = new Editor("abcdefgh12345");
        CommandHistory history = new CommandHistory();
        Application app = new Application(history);


        Command copyCommand = new CopyCommand(app, editor);
        Command pasteCommand = new PasteCommand(app, editor);
        Command cutCommand = new CutCommand(app, editor);

        app.executeCommand(copyCommand);
        app.executeCommand(pasteCommand);

        System.out.println(app.clipboard);
        System.out.println(editor.getSelection());
        System.out.println(editor.text);

    }
}
