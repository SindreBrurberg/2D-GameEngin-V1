package Engin.Listener;

import Engin.ScreenFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class MousepadListener implements MouseListener, MouseMotionListener, IMouseListner {

    private int mouseX, mouseY;
    private boolean clicked;

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Clicked();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        clicked = true;
        Pressed();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        clicked = false;
        Released();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        Entered();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        Exited();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        Dragged();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        Moved();
    }

    public boolean isMousePressed()
    {
        return clicked;
    }

    public int getX()
    {
        return mouseX;
    }

    public void setX(int x)
    {
        mouseX = x;
    }

    public int getY()
    {
        return mouseY;
    }

    public void setY(int y)
    {
        mouseY = y;
    }

    public Rectangle getMouse(ScreenFactory screenFactory)
    {
        return new Rectangle((int) (MouseInfo.getPointerInfo().getLocation().getX() - screenFactory.getGame().getWindow().getX() - 3), (int) (MouseInfo.getPointerInfo().getLocation().getY() - screenFactory.getGame().getWindow().getY() - 26), 1, 1);
    }

    public void resetMousePressed()
    {
        clicked = false;
    }

    public void resetMouseCord()
    {
        mouseX = 0;
        mouseY = 0;
    }

    @Override
        public void Moved() {

    }

    @Override
    public void Exited() {

    }

    @Override
    public void Entered() {

    }

    @Override
    public void Clicked() {

    }

    @Override
    public void Pressed() {

    }

    @Override
    public void Released() {

    }

    @Override
    public void Dragged() {

    }
}
