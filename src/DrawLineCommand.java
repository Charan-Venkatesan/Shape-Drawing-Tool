import java.awt.*;
public class DrawLineCommand extends Command {
    private Line line;
    int xAxis;
    int yAxis;
    public DrawLineCommand(Line line, int xAxis, int yAxis){
        this.line = line;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    @Override
    public void execute(Graphics g) {
        line.drawShape(xAxis, yAxis, g);
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
