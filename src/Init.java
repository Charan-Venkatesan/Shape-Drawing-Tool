import java.awt.*;

public class Init extends ControllerState {
    private static Init init;
    private Init(){}
    public static Init getInstance(){
        if(init == null){
            init = new Init();
        }
        return init;
    }
    public ControllerState lineButtonClicked(HWGUI rootPane){
        rootPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        return AddLineState.getInstance();
    }
    public ControllerState boxButtonClicked(HWGUI rootPane){
        rootPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        return AddBoxState.getInstance();
    }
    public ControllerState circleButtonClicked(HWGUI rootPane){
        rootPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        return AddCircleState.getInstance();
    }
    public ControllerState undoButtonClicked(){
        return UndoShapeState.getInstance();
    }
    public ControllerState redoButtonClicked(){
        return RedoShapeState.getInstance();
    }
}
