package extraLarge;

public class Rule {
    private String content;
    private boolean state;

    public Rule(String content, boolean state) {
        this.content = content;
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
