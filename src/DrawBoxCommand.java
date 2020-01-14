import java.awt.*;

public class DrawBoxCommand extends Command {

    private Box box;
    private int xAxis;
    private int yAxis;

    public DrawBoxCommand(Box box, int xAxis, int yAxis){
        this.box = box;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    @Override
    public void execute(Graphics g) {
        box.drawShape(xAxis, yAxis, g);
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
