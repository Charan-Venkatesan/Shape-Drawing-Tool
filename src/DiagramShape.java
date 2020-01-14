import java.awt.*;

public abstract class DiagramShape {
    int xAxis;
    int yAxis;
    public abstract void drawShape(int x, int y, Graphics g);
    public void remove(){}
    public  DiagramShape get(){return null;}
    public void add(Command c){}
}

