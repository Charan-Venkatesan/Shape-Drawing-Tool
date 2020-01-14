import java.awt.*;

//Singleton Pattern is applied here
public class AddCircleState extends ControllerState {
    private static AddCircleState addCircleState;
    public Command command;
    private AddCircleState(){}
    public static AddCircleState getInstance(){
        if(addCircleState == null){
            addCircleState = new AddCircleState();
        }
        return addCircleState;
    }
    public ControllerState canvasClicked(CommandManager commandManager, DiagramShape compositeShape, Graphics g, HWGUI rootpane, int xAxis, int yAxis){
        //Composite Pattern is applied here
        compositeShape.drawShape(xAxis, yAxis, g);
        DiagramShape circle = new Circle();
        //Command Pattern is applied here
        command = new DrawCircleCommand((Circle) circle, xAxis, yAxis);
        commandManager.executeCommand(command, g);
        compositeShape.add(command);
        rootpane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        return Init.getInstance();
    }
}
