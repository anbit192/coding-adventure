package designpatterns.state.canvas;

public class EraserTool implements ToolType {

    @Override
    public void mousePressed() {
        System.out.println("Erasing.");
    }

    @Override
    public void mouseRelease() {
        System.out.println("Stop erase.");
    }
}
