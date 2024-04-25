package mandelbrot_set;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fractal {
    Complex z_0;
    ArrayList<Point> screenBuffer;
    int maxIteration;


    public Fractal(int maxIter){
        System.out.println("Mandelbrot set selected.");
        this.maxIteration = maxIter;
    }


    public void createScreenBuffer(int width, int height){
        this.screenBuffer = new ArrayList<Point>();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                this.screenBuffer.add(new Point(i, j));
            }
        }
        System.out.println("Buffer initialized.");
    }
    public void run(){
        int width = 1000;
        int height = 1000;

        double minX = -2.0;
        double minY = -1.5;
        double maxX = 0.7;
        double maxY = 2.0;

        Color c;
        int val;
        CoordinateFrame cFrame;

        DrawPanel imageOnCanvas;

        JFrame appWindow = new JFrame();
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setSize(width,height);
        appWindow.setTitle("Mandelbrot set");
        appWindow.setLayout(new BorderLayout());
        imageOnCanvas = new DrawPanel(width,height);
        appWindow.add(imageOnCanvas, BorderLayout.CENTER);
        appWindow.setVisible(true);

      //  cFrame = new CoordinateFrameBoxed(width,height,minX,minY,maxX,maxY);
        cFrame = new CoordinateFrameCentered(width,height,0.4,0.4,0.0001,0.0001);
        createScreenBuffer(width,height);
        long  tStart = System.nanoTime();
        System.out.println("Starting calculate buffer.... ");
        MandelbrotSet pc = new MandelbrotSet(maxIteration);
        pc.isMandelbrotArray(screenBuffer,cFrame);
        System.out.println("Done in  "+ (System.nanoTime()-tStart)/1.e9+"sec");
        imageOnCanvas.drawPointsArray(screenBuffer);

    }

}
