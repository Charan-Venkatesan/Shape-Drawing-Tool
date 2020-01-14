import java.awt.*;

public abstract class Command {
    public abstract void execute(Graphics g);
    public abstract void undo(DiagramShape s);
    public abstract void redo(DiagramShape s, Command c);
}
