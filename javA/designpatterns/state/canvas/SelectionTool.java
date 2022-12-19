package designpatterns.state.canvas;

public class SelectionTool implements ToolType {

    @Override
    public void mousePressed() {
        System.out.println("Selecting area.");
    }

    @Override
    public void mouseRelease() {
        System.out.println("Show up selected area.");
    }
}
