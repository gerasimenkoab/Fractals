package mandelbrot_set;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class AppGUI extends JFrame {
    int windowW;
    int windowH;
    private Map<String,JComponent> componentMap;

    public AppGUI(String appName, int width, int height){
        this.windowW = width;
        this.windowH = height;
        componentMap = new HashMap<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setTitle("Mandelbrot set");
        setLayout(new BorderLayout());

        componentMap.put( "imagePanel", new DrawPanel(width,height));
        add(componentMap.get("imagePanel"), BorderLayout.CENTER);

        componentMap.put("closeButton", new JButton("Close"));
        add(componentMap.get("closeButton"), BorderLayout.SOUTH);
        setVisible(true);

    }
    public void drawArray(ArrayList<Point> points){
        DrawPanel component = (DrawPanel) componentMap.get("imagePanel");
        component.drawPointsArray(points);
    }
}
