package designpatterns.state.canvas;

public class BrushTool implements ToolType {

    @Override
    public void mousePressed() {
        System.out.println("Draw lines.");
    }

    @Override
    public void mouseRelease() {
        System.out.println("Stop drawing.");
    }
}
