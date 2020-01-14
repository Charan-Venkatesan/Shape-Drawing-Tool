import java.awt.*;
//Singleton pattern is applied here
public class AddLineState extends ControllerState {
    private static AddLineState addLineState;
    public Command command;
    private AddLineState(){}
    public static AddLineState getInstance(){
        if(addLineState == null){
            addLineState = new AddLineState();
        }
        return addLineState;
    }
    public ControllerState canvasClicked(CommandManager commandManager, DiagramShape compositeShape, Graphics g, HWGUI rootpane, int xAxis, int yAxis){
        //Composite Pattern is applied here
        compositeShape.drawShape(xAxis, yAxis, g);
        DiagramShape line = new Line();
        //Command pattern is applied here
        command = new DrawLineCommand((Line) line, xAxis, yAxis);
        commandManager.executeCommand(command, g);
        compositeShape.add(command);
        rootpane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        return Init.getInstance();
    }
}
