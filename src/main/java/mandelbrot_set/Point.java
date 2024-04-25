package mandelbrot_set;

import java.awt.*;

public class Point {
    protected int x, y;
    protected Color color;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.color =  new Color(0,0,0);
    }

    public Point(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = new Color(color,color,color);
    }

    public Point(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
