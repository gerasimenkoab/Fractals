package mandelbrot_set;
import javax.swing.JPanel;
import java.awt.*;

public class Plot extends JPanel {
    // class for plotting graphs
    int sizeX;
    int sizeY;
    Point p;
    public Plot(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        //initislise JFrame and PaintJPlane
    }

    public void putPixel(int x, int y, int color){
        p.x = x;
        p.y = y;
//        paintComponent();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillOval(p.x,p.y,1,1);
    }
}
