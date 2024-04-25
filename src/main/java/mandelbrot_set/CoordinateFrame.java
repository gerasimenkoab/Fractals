package mandelbrot_set;

public abstract interface CoordinateFrame {


    public abstract double getX(int stepIndex);

    public abstract double getY(int stepIndex);
}
