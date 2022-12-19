package designpatterns.state.canvas;

public class App {
    public static void main(String[] args) {
        ToolType selectionTool = new SelectionTool();
        ToolType eraserTool = new EraserTool();
        ToolType brushTool = new BrushTool();

        Canvas canvas = new Canvas();
        canvas.setTool(selectionTool);
        canvas.mousePressed();
        canvas.mouseRelease();

        canvas.setTool(eraserTool);
        canvas.mousePressed();
        canvas.mouseRelease();



    }
}
