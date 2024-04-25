package mandelbrot_set;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private BufferedImage canvas;

    public DrawPanel(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setPreferredSize(new Dimension(width, height));
    }

    public void putPixel(int x, int y, Color color) {
        canvas.setRGB(x, y, color.getRGB());
        repaint();
    }
    public void drawPointsArray(ArrayList<Point> pointsArray){
        for(Point p:pointsArray){
            canvas.setRGB(p.getX(),p.getY(),p.getColor().getRGB());
        }
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, this);
    }
}