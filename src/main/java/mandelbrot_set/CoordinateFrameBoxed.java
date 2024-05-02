package mandelbrot_set;

public class CoordinateFrameBoxed implements CoordinateFrame {
    int width;
    int height;
    double maxX;
    double maxY;
    double minX;
    double minY;
    double stepX;
    double stepY;
    public CoordinateFrameBoxed(int width, int height, double minX, double minY, double maxX, double maxY){
        this.width = width;
        this.height = height;
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;
        this.stepX =(maxX-minX) / width;
        this.stepY =(maxY-minY) / height;
    }

    public double getX(int stepIndex){
        // get X coordinate  in ordinary system of coordinates X - directed right, Y- directed up
        return minX + (stepIndex) * stepX;
    }
    public double getY(int stepIndex){
        // get Y coord in ordinary system of coordinates X - directed right, Y- directed up
        return minY + (height- stepIndex) * stepY;
    }
    public void setCenter(double centerX, double centerY){
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        this.maxX = centerX + stepX * halfWidth;
        this.maxY = centerY + stepY * halfHeight;
        this.minX = centerX - stepX * halfWidth;
        this.minY = centerY - stepY * halfHeight;
    }
}
