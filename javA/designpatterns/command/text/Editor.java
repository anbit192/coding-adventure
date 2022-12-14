package designpatterns.command.text;

public class Editor {
    public String text;
    public String selectedText;

    public Editor(String text) {
        this.text = text;
    }

    public String getSelection() {
        this.selectedText = text.substring(0,text.length() - 1);
        return this.selectedText;
    }

    public void deleteSelection() {
        this.selectedText = null;
    }

    public void replaceSelection(String text) {
        this.selectedText = text;
    }
}
