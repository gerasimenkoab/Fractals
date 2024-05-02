package mandelbrot_set;

import java.awt.*;
import java.util.ArrayList;

public class MandelbrotSet {
    Complex z_0;
    int maxIteration;
    public MandelbrotSet( int maxIter){
        this.maxIteration = maxIter;
    }

    public int isMandelbrot(Complex z, Complex z_0, int iter) {
        // Returns true if z_0 is in Mandelbrot Set.
        if (z.module() > 2.0) {
            return maxIteration - iter;
        } else if (iter == 0) {
            return maxIteration - iter;
        } else {
//            iter--;
            return isMandelbrot( (z.multiply(z)).add(z_0), z_0, --iter);
        }
    }

    public void isMandelbrotArray(ArrayList<Point> points, CoordinateFrame cFrame){
        int val;
        Color c;
        double reZ, imZ;
        // combinations:
//        reZ = -0.79;
//        imZ = 0.15;
//        reZ = 0.31;
//        imZ = -0.01;
//        reZ = -1.47;
//        imZ = -0.0;
//        reZ = 0.31;
//        imZ = -0.01;
        reZ = -0.5;
        imZ = -0.0;
        Complex z_c = new Complex(reZ, imZ);
        cFrame.setCenter(reZ, imZ);
        for (Point p:points){
            z_0 = new Complex(cFrame.getX(p.getX()), cFrame.getY(p.getY()));
//            val = isMandelbrot(z_0, z_c, maxIteration);
            val = isMandelbrot(z_0, z_0, maxIteration);

//            c = new Color(0,val,255);
            c = Color.getHSBColor(val / 64.0f, 1.0f, 0.6f);
            p.setColor(c);
        }
    }

}
