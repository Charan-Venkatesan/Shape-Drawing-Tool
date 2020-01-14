import java.awt.*;
//Singleton pattern is applied here
public class AddBoxState extends ControllerState {
    private static AddBoxState addBoxState;
    public Command command;
    private AddBoxState(){}
    public static AddBoxState getInstance(){
        if(addBoxState == null){
            addBoxState = new AddBoxState();
        }
        return addBoxState;
    }
    public ControllerState canvasClicked(CommandManager commandManager, DiagramShape compositeShape, Graphics g, HWGUI rootpane, int xAxis, int yAxis){
        //Composite Pattern is applied here
        compositeShape.drawShape(xAxis, yAxis, g);
        DiagramShape box = new Box();
        //command pattern is applied here
        command = new DrawBoxCommand((Box) box, xAxis, yAxis);
        commandManager.executeCommand(command, g);
        compositeShape.add(command);
        rootpane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        return Init.getInstance();
    }
}
