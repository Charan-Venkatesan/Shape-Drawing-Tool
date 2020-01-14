import java.awt.*;
import java.util.Iterator;
import java.util.Stack;

public class CompositeShape extends DiagramShape {
    Stack<Command> children = new Stack<>();
    @Override
    public void drawShape(int x, int y, Graphics g) {
        //Iterator pattern is applied here
        Iterator<Command> it = children.iterator();
        while(it.hasNext()){
            Command cmd = it.next();
            cmd.execute(g);
        }
    }
    public void add(Command s){
        children.push(s);
    }
    public void remove(){
        children.pop();
    }
}
