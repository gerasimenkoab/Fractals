package mandelbrot_set;

public class pointChecker {
    Complex z_0;
    int maxIteration;
    public pointChecker(Complex z_0, int maxIter){
        this.z_0 = z_0;
        this.maxIteration = maxIter;
    }

    public boolean isMandelbrot(Complex z_n, int iter) {
        // Returns true if z_0 is in Mandelbrot Set.
        Complex z_next = (z_n.multiply(z_n)).add(z_0);
        if (z_next.module() > 2.0) {
            return false;
        } else if (iter == 0) {
            return true;
        } else {
            iter--;
            isMandelbrot(z_next, iter);
        }
        return true;
    }
}
