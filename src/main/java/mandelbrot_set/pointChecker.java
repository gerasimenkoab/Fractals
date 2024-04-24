package mandelbrot_set;

public class pointChecker {
    Complex z_0;
    int maxIteration;
    public pointChecker(Complex z_0, int maxIter){
        this.z_0 = z_0;
        this.maxIteration = maxIter;
    }

    public int isMandelbrot(Complex z_n, int iter) {
        // Returns true if z_0 is in Mandelbrot Set.
        if (z_n.module() > 2.0) {
            return iter;
        } else if (iter == 0) {
            return iter;
        } else {
            iter--;
            return isMandelbrot( (z_n.multiply(z_n)).add(z_0), iter);
        }
    }

    // return number of iterations to check if c = a + ib is in Mandelbrot set
    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.module() > 2.0) return t;
            z = z.multiply(z).add(z0);
        }
        return max;
    }
}
