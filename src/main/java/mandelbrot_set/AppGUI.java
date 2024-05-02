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
    private Map<String,JButton> buttonMap;
    private Object master;

    public AppGUI(String appName, int width, int height, Object master){
        this.master = master;
        this.windowW = width;
        this.windowH = height;
        componentMap = new HashMap<>();
        buttonMap = new HashMap<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setTitle("Mandelbrot set");
        setLayout(new BorderLayout());


        DrawPanel panel = new DrawPanel(1000,1000);
        componentMap.put( "imagePanel", panel);
        MouseEventHandler mHandler = new MouseEventHandler(this.master);
        panel.addMouseListener(mHandler);
        panel.addMouseMotionListener(mHandler);
        add(panel, BorderLayout.CENTER);

        buttonMap.put("close", new JButton("Close"));
        buttonMap.get("close").addActionListener(e->System.exit(0));
        add(buttonMap.get("close"), BorderLayout.SOUTH);

        setVisible(true);

    }

    public void drawArray(ArrayList<Point> points){
        DrawPanel component = (DrawPanel) componentMap.get("imagePanel");
        component.drawPointsArray(points);
    }
}
