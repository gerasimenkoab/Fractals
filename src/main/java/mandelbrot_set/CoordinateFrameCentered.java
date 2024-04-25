package mandelbrot_set;

public class CoordinateFrameCentered implements CoordinateFrame {
    int width;
    int height;
    double maxX;
    double maxY;
    double minX;
    double minY;
    double stepX;
    double stepY;

    public CoordinateFrameCentered(int width, int height, double centerX, double centerY, double stepX, double stepY){
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        this.width = width;
        this.height = height;
        this.maxX = centerX + stepX * halfWidth;
        this.maxY = centerY + stepY * halfHeight;
        this.minX = centerX - stepX * halfWidth;
        this.minY = centerY - stepY * halfHeight;
        this.stepX = stepX;
        this.stepY = stepY;
    }
    public double getX(int stepIndex){
        // get X coordinate  in ordinary system of coordinates X - directed right, Y- directed up
        return minX + (stepIndex) * stepX;
    }
    public double getY(int stepIndex){
        // get Y coord in ordinary system of coordinates X - directed right, Y- directed up
        return minY + (height-stepIndex) * stepY;
    }

}
