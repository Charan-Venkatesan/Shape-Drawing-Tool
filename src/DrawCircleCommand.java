import java.awt.*;

public class DrawCircleCommand extends Command {
    private Circle circle;
    private int xAxis;
    private int yAxis;

    public DrawCircleCommand(Circle circle, int xAxis, int yAxis){
        this.circle = circle;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public void execute(Graphics g) {
        circle.drawShape(xAxis, yAxis, g);
    }

    @Override
    public void undo(DiagramShape compositeShape) {
        compositeShape.remove();
    }

    @Override
    public void redo(DiagramShape compositeShape, Command redoCommand) {
        compositeShape.add(redoCommand);
    }
}
