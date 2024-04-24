package mandelbrot_set;

public class pointChecker {
    Complex z_0;
    int maxIteration;
    public pointChecker(Complex z_0, int maxIter){
        this.z_0 = z_0;
        this.maxIteration = maxIter;
    }

    public int isMandelbrot(Complex z, int iter) {
        // Returns true if z_0 is in Mandelbrot Set.
        if (z.module() > 2.0) {
            return maxIteration - iter;
        } else if (iter == 0) {
            return maxIteration - iter;
        } else {
//            iter--;
            return isMandelbrot( (z.multiply(z)).add(z_0), --iter);
        }
    }

}
