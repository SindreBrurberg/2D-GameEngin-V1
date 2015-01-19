package Engin.Listener;

import java.awt.event.KeyEvent;

/**
 * Created by aa311 on 08.01.2015.
 */
public interface IKeyboardListner {
    public void Typed(KeyEvent e);
    public void Pressed(KeyEvent e);
    public void Released(KeyEvent e);
    public boolean isKeyPressed(int key);
    public boolean isKeyReleased(int key);
}
