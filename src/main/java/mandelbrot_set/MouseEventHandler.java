package mandelbrot_set;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class MouseEventHandler implements MouseInputListener {
    Object master;
    public MouseEventHandler(Object master){
        this.master = master;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Mouse coordinates: x = "+ x + ", y =" + y );
        Fractal inst = (Fractal)master;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
