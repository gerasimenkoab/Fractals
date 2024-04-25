package mandelbrot_set;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Mandelbrot extends JFrame {
    Complex z_0;
    ArrayList<Point> screenBuffer;
    int maxIteration;
    int width = 1000;
    int height = 1000;


    DrawPanel imageOnCanvas;
    public Mandelbrot( int maxIter){
        super("Mandelbrot set");
        setLayout(new BorderLayout());
        imageOnCanvas = new DrawPanel(width,height);
        add(imageOnCanvas, BorderLayout.CENTER);
        System.out.println("Mandelbrot set selected.");
        this.maxIteration = maxIter;


    }


    public void manyPointTest(){
//        pointTest(0,0, true); //y
//        pointTest(2,0, false); //n
//        pointTest(1,1, false); //n
//        pointTest(0,1, true); //y
//        pointTest(-0.5,0, true); //y
//        pointTest(-0.1,-0.64, true); //y
    }

//    public void pointTest(double re, double im, boolean ans){
//        boolean result;
//        Complex z_test = new Complex(re, im);
//        pointChecker pc = new pointChecker(z_test, maxIteration);
//        result = pc.isMandelbrot(z_test, maxIteration);
//        System.out.println("Testing point " + z_test + "Result " + result + ((result == ans) ? " Passed" : " Failed") );
//
//    }

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
        double leftLowerX = -2.0;
        double leftLowerY = -1.0;
        double stepX = 0.002;
        double stepY = 0.002;
        Color c;
        int val;

        createScreenBuffer(width,height);
        long  tStart = System.nanoTime();
        System.out.println("Starting calculate buffer.... ");
        for (Point p:screenBuffer){
            z_0 = new Complex(p.getX() * stepX + leftLowerX, p.getY() * stepY + leftLowerY);
            pointChecker pc = new pointChecker(z_0, maxIteration);
            val = pc.isMandelbrot(z_0, maxIteration);

//            c = new Color(0,val,0);
            c = Color.getHSBColor(val / 64.0f, 1.0f, 0.6f);
            p.setColor(c);
        }
        System.out.println("Done in  "+ (System.nanoTime()-tStart)/1.e9+"sec");
        for (Point p:screenBuffer){
            imageOnCanvas.putPixel(p.getX(),p.getY(), p.getColor());
        }

    }

}
