package designpatterns.memento.editor;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states;

    public History() {
        states = new ArrayList<>();
    }

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        EditorState lastState = states.get(states.size() - 1);
        states.remove(lastState);
        return lastState;
    }
}
