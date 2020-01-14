import java.awt.*;
import java.awt.event.ActionEvent;

public class HWController {
    ActionEvent buttonEvent;
    int xAxis, yAxis;
    DiagramShape compositeShape = new CompositeShape();
    ControllerState controllerState = Init.getInstance();
    public CommandManager commandManager = new CommandManager();
    enum states {Init, AddLineState, AddBoxState, AddCircleState, UndoState, RedoState};
    states state = states.Init;

    public void setButton(ActionEvent e) {
        buttonEvent = e;
    }

    public void setCoordinates(int x, int y) {
        xAxis = x;
        yAxis = y;
    }

    public void doNextEvent(Graphics g, HWGUI rootPane){
        String clickedButton;
        if(buttonEvent != null){
            clickedButton = buttonEvent.getActionCommand();

            //State Pattern is applied here
            switch(state){
                case Init:
                    switch(clickedButton){
                        case "Line":
                            //composite pattern is applied here
                            compositeShape.drawShape(xAxis, yAxis, g);
                            controllerState = controllerState.lineButtonClicked(rootPane);
                            state = states.AddLineState;
                            break;
                        case "Box":
                            compositeShape.drawShape(xAxis, yAxis, g);
                            controllerState = controllerState.boxButtonClicked(rootPane);
                            state = states.AddBoxState;
                            break;
                        case "Circle":
                            compositeShape.drawShape(xAxis, yAxis, g);
                            controllerState = controllerState.circleButtonClicked(rootPane);
                            state = states.AddCircleState;
                            break;
                        case  "Undo":
                            controllerState = controllerState.undoButtonClicked();
                            state = states.UndoState;
                            controllerState = controllerState.undoShape(commandManager, compositeShape, xAxis, yAxis, g);
                            state = states.Init;
                            buttonEvent = null;
                            break;
                        case "Redo":
                            controllerState = controllerState.redoButtonClicked();
                            state = states.RedoState;
                            controllerState = controllerState.redoShape(commandManager, compositeShape, xAxis, yAxis, g);
                            state = states.Init;
                            buttonEvent = null;
                            break;
                        default:break;
                    }
                    break;
                case AddLineState:
                    controllerState = controllerState.canvasClicked(commandManager, compositeShape, g, rootPane, xAxis, yAxis);
                    state = states.Init;
                    buttonEvent = null;
                    break;
                case AddBoxState:
                    controllerState = controllerState.canvasClicked(commandManager, compositeShape, g, rootPane, xAxis, yAxis);
                    state = states.Init;
                    buttonEvent = null;
                    break;
                case AddCircleState:
                    controllerState =controllerState.canvasClicked(commandManager, compositeShape, g, rootPane, xAxis, yAxis);
                    state = states.Init;
                    buttonEvent = null;
                    break;
                default: break;
            }
        }
        else{
            //composite pattern is applied here
            compositeShape.drawShape(xAxis, yAxis, g);
        }
    }
}
