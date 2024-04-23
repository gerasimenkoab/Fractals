package mandelbrot_set;

import javax.swing.*;

public class Mandelbrot {
    Complex z_0;
    int maxIteration;
    public Mandelbrot( int maxIter){
        System.out.println("Mandelbrot set selected.");
        this.maxIteration = maxIter;
    }

    public void manyPointTest(){
        pointTest(0,0, true); //y
        pointTest(2,0, false); //n
        pointTest(1,1, false); //n
        pointTest(0,1, true); //y
        pointTest(-0.5,0, true); //y
        pointTest(-0.1,-0.64, true); //y
    }

    public void pointTest(double re, double im, boolean ans){
        boolean result;
        Complex z_test = new Complex(re, im);
        pointChecker pc = new pointChecker(z_test, maxIteration);
        result = pc.isMandelbrot(z_test, maxIteration);
        System.out.println("Testing point " + z_test + "Result " + result + ((result == ans) ? " Passed" : " Failed") );

    }
    public void run(){
        // prepare canvas 500x500
        PlotFrame ui = new PlotFrame();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setSize(300,200);
        ui.setLocation(1000,0);
        ui.setVisible(true);
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
