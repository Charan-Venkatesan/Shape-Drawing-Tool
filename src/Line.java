import java.awt.*;
import java.util.Random;

public class Line extends DiagramShape {
    int xAxis2 = new Random().nextInt(500);;
    int yAxis2 = new Random().nextInt(500);;
    @Override
    public void drawShape(int x, int y, Graphics g) {
        this.xAxis = x;
        this.yAxis = y;
        g.drawLine(xAxis,yAxis,xAxis2,yAxis2);
    }
}
