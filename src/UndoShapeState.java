import java.awt.*;

public class UndoShapeState extends ControllerState {
    private static UndoShapeState undoShapeState;

    UndoShapeState(){}
    public static UndoShapeState getInstance(){
        if(undoShapeState == null){
            undoShapeState = new UndoShapeState();
        }
        return undoShapeState;
    }
    public ControllerState undoShape(CommandManager commandManager, DiagramShape compositeShape, int xAxis, int yAxis, Graphics g){
        commandManager.undo(compositeShape);
        compositeShape.drawShape(xAxis, yAxis, g);
        return Init.getInstance();
    }
}
