package designpatterns.state.canvas;

public class Canvas {

    private ToolType tool;

    public ToolType getTool() {
        return tool;
    }

    public void setTool(ToolType tool) {
        this.tool = tool;
    }

    public void mousePressed() {
        tool.mousePressed();
    }

    public void mouseRelease() {
        tool.mouseRelease();
    }
}
