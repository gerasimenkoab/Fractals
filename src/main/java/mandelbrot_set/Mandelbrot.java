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
        createScreenBuffer(width,height,-2.0,-1.0,0.002,0.002);
//        pointTest(0,0, true); //y
//        pointTest(2,0, false); //n
//        pointTest(1,1, false); //n
//        pointTest(0,1, true); //y
//        pointTest(-0.5,0, true); //y
//        pointTest(-0.1,-0.64, true); //y
        long  tStart = System.nanoTime();
        System.out.println("Starting calculate buffer.... ");
        boolean r;
        Color c;
        int val;
        float hue;
        for (Point p:screenBuffer){
            z_0 = p.getPoint();
            pointChecker pc = new pointChecker(z_0, maxIteration);
            val = pc.isMandelbrot(z_0, maxIteration);

            c = new Color(val,val,val);
            hue = val / 64.0f;
            c = Color.getHSBColor(hue, 1.0f, 0.6f);
            imageOnCanvas.putPixel(p.getIX(),p.getIY(), c);
        }
        System.out.println("Done in  "+ (System.nanoTime()-tStart)/1.e9+"sec");
    }

//    public void pointTest(double re, double im, boolean ans){
//        boolean result;
//        Complex z_test = new Complex(re, im);
//        pointChecker pc = new pointChecker(z_test, maxIteration);
//        result = pc.isMandelbrot(z_test, maxIteration);
//        System.out.println("Testing point " + z_test + "Result " + result + ((result == ans) ? " Passed" : " Failed") );
//
//    }

    public void createScreenBuffer(int width, int height, double leftLowerX,double leftLowerY, double stepX,double stepY){
        this.screenBuffer = new ArrayList<Point>();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                this.screenBuffer.add(new Point(i * stepX + leftLowerX, j * stepY + leftLowerY,i,j,0));
            }
        }
        System.out.println("Buffer initialized.");
    }
    public void run(){
        // prepare canvas 500x500
        PlotFrame ui = new PlotFrame();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setSize(300,200);
        ui.setLocation(1000,0);
        ui.setVisible(true);

        createScreenBuffer(400,400,-2.,-2.,0.01,0.01);
        double scaler =10;
//        for i from 1 to 500
//            for j from 1 to 500
//                x = i / scaler;
//                y = j / scaler;
//                if (isMandelbrot(new Complex(x,y, maxIteration))){
//                    putPixel(i,j,black);
//                }else{
//                    putPixel(i,j,white);
//                }

    }

}
