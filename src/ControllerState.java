import java.awt.*;

public class ControllerState {
    public ControllerState lineButtonClicked(HWGUI rootPane){
        return this;
    }
    public ControllerState boxButtonClicked(HWGUI rootPane) {
        return this;
    }
    public ControllerState circleButtonClicked(HWGUI rootPane){
        return this;
    }
    public ControllerState undoButtonClicked(){
        return this;
    }
    public ControllerState redoButtonClicked(){
        return this;
    }
    public ControllerState canvasClicked(CommandManager commandManager, DiagramShape c, Graphics g, HWGUI rootPane, int x, int y){
        return this;
    }
    public ControllerState undoShape(CommandManager cm, DiagramShape c, int x, int y, Graphics g){
        return this;
    }
    public ControllerState redoShape(CommandManager cm, DiagramShape c, int x, int y, Graphics g){
        return this;
    }

}
