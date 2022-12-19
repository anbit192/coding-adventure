package designpatterns.memento.editor;

public class App {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("1");
        history.push(editor.saveState());
        editor.setContent("2");
        history.push(editor.saveState());
        editor.setContent("3");
        history.push(editor.saveState());

        editor.restoreState(history.pop());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());

    }
}
