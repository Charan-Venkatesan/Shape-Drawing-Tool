import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HWGUI extends JFrame{
    private JPanel contentPane;
    private JButton lineButton;
    private JButton redoButton;
    private JButton undoButton;
    private JButton circleButton;
    private JButton boxButton;
    static HWController HWC;
    public MyCanvas myCanvas1;

    public HWGUI() {
        //Controller pattern is applied here
        HWC = new HWController();
        setContentPane(contentPane);
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButton(e);
            }
        });
        boxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButton(e);
            }
        });
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButton(e);
            }
        });
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButton(e);
            }
        });
        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButton(e);
            }
        });
    }
    private void setButton(ActionEvent e) {
        HWC.setButton(e);
        repaint();
    }

    public static void main(String[] args) {
        HWGUI frame = new HWGUI();
        MyCanvas c = new MyCanvas(frame);
        frame.add(c);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
         myCanvas1 = new MyCanvas(this);
        // TODO: place custom component creation code here
    }
}
class  MyCanvas extends JPanel{
    Shape s;
    int xAxis, yAxis;
    HWController HWC;
    HWGUI frame;
    MyCanvas(HWGUI frame){
        this.frame = frame;
        this.HWC = frame.HWC;
        addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent me){
                xAxis = me.getX();
                yAxis = me.getY();
                HWC.setCoordinates(xAxis, yAxis);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        HWC.doNextEvent(g, frame);
    }
}
