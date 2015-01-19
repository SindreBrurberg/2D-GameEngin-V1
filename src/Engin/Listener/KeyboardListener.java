package Engin.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class KeyboardListener implements KeyListener, IKeyboardListner {

    private boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e)
    {
        Typed(e);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        Pressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
        Released(e);
    }

    @Override
    public void Typed(KeyEvent e) {

    }

    @Override
    public void Pressed(KeyEvent e) {

    }

    @Override
    public void Released(KeyEvent e) {

    }

    public boolean isKeyPressed(int key)
    {
        return keys[key];
    }

    public boolean isKeyReleased(int key)
    {
        return !keys[key];
    }
}
