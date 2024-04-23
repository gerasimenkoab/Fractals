package mandelbrot_set;

import javax.swing.*;
import java.awt.*;


public class PlotFrame extends JFrame{
    private Plot drawPanel;
    private JLabel statusBar;
    int sizeXY;
    public PlotFrame(){
        super("Plot");
        setLayout(new BorderLayout());
        sizeXY = 500;
        drawPanel = new Plot(sizeXY,sizeXY);
        add(drawPanel, BorderLayout.CENTER);

        statusBar = new JLabel("Mandelbrot Set");
        this.add(statusBar, BorderLayout.SOUTH);
    }// end of constructor
}
