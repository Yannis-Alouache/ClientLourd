package org.tp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAdapter implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        System.out.println("clic");

        int x,y;

        x=e.getX();
        y=e.getY();

        System.out.println("x:"+x + "\ny:"+y);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
