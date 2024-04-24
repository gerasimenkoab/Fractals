package mandelbrot_set;

public class Point {
    protected Complex z;
    protected int color;
    protected int ix, iy;
    public Point(double x, double y){
        this.z = new Complex(x,y);
        this.color = 0;
    }
    public Point(double x, double y, int color){
        this.z = new Complex(x,y);
        this.color = color;
    }
    public Point(double x, double y, int ix, int iy, int color){
        this.z = new Complex(x,y);
        this.color = color;
        this.ix = ix;
        this.iy = iy;
    }
    public Point(Complex z, int color){
        this.z = z;
        this.color = color;
    }

    public Complex getPoint(){
        return z;
    }

    public int getColor(){
        return color;
    }

    public int getIX(){
        return this.ix;
    }
    public int getIY(){
        return this.iy;
    }
}
