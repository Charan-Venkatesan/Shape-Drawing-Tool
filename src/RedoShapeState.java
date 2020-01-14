import java.awt.*;

public class RedoShapeState extends ControllerState {
    private static RedoShapeState redoShapeState;
    RedoShapeState(){}
    public static RedoShapeState getInstance(){
        if(redoShapeState == null){
            redoShapeState = new RedoShapeState();
        }
        return redoShapeState;
    }
    public ControllerState redoShape(CommandManager commandManager, DiagramShape compositeShape, int xAxis, int yAxis, Graphics g){
        commandManager.redo(compositeShape);
        compositeShape.drawShape(xAxis, yAxis, g);
        return Init.getInstance();
    }
}
