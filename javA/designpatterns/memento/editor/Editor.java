package designpatterns.memento.editor;

public class Editor {
    private String content;

    public EditorState saveState() {
        return new EditorState(content);
    }

    public void restoreState(EditorState state) {
        content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
