import java.awt.*;

public class Box extends DiagramShape {
    int width = 80;
    int height = 80;
    @Override
    public void drawShape(int x, int y, Graphics g) {
        this.xAxis = x;
        this.yAxis = y;
        g.drawRect(xAxis, yAxis, width, height);
    }
}
