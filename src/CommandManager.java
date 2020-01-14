import java.awt.*;
import java.util.Stack;

public class CommandManager {
    private Stack<Command> normalStack = new Stack<>();
    private Stack<Command> reverseStack = new Stack<>();

    public void executeCommand(Command cmd, Graphics g){
        if(!reverseStack.isEmpty()){
            reverseStack.clear();
        }
        cmd.execute(g);
        normalStack.push(cmd);
    }
    public void undo(DiagramShape compositeShape){
        Command undoCommand;
        if(!normalStack.isEmpty()){
            undoCommand = normalStack.pop();
            reverseStack.push(undoCommand);
            undoCommand.undo(compositeShape);
        }
    }
    public void redo(DiagramShape compositeShape){
        Command redoCommand;
        if(!reverseStack.isEmpty()){
            redoCommand = reverseStack.pop();
            redoCommand.redo(compositeShape, redoCommand);
            normalStack.push(redoCommand);
        }
    }
}
