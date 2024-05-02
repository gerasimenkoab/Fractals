package mandelbrot_set;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fractal {
    Complex z_0;
    int maxIteration;
    ArrayList<Point> screenBuffer;


    public Fractal(int maxIter){
        System.out.println("Mandelbrot set selected.");
        this.maxIteration = maxIter;
    }


    public void run(){
        int width = 1000;
        int height = 1100;

        double minX = -2.0;
        double minY = -1.5;
        double maxX = 0.7;
        double maxY = 2.0;

        Color c;
        int val;
        CoordinateFrame cFrame;

        MandelbrotSet pc = new MandelbrotSet(maxIteration);
        screenBuffer = createScreenBuffer(1000,1000);

        AppGUI appWindow = new AppGUI("Mandelbrot Set", width,height, this);

        long  tStart = System.nanoTime();
        System.out.println("Starting calculate buffer.... ");

        //  cFrame = new CoordinateFrameBoxed(width,height,minX,minY,maxX,maxY);
        cFrame = new CoordinateFrameCentered(width,height,0.0,0.0,0.002,0.002);
        pc.isMandelbrotArray(screenBuffer,cFrame);

        System.out.println("Done in  "+ (System.nanoTime()-tStart)/1.e9+"sec");

        appWindow.drawArray(screenBuffer);

    }

    public ArrayList<Point> createScreenBuffer(int width, int height){
        ArrayList<Point> buffer = new ArrayList<>();
        try {
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    buffer.add(new Point(i, j));
                }
            }
        }catch(OutOfMemoryError e){
            e.printStackTrace();
            return null;
        }
        System.out.println("Buffer initialized.");
        return buffer;
    }

}
