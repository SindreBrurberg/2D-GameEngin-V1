package Engin.Core;

import Engin.Listener.KeyboardListener;
import Engin.Listener.MousepadListener;
import Engin.ScreenFactory;

import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private final JFrame window = new JFrame();
    private final ScreenFactory screenFactory;
    private final KeyboardListener keyboardListener;
    private final MousepadListener mousepadListener;
    protected int sleep = 10;

    public Game(int windowX, int windowY, String title)
    {
        window.setSize(windowX + 6, windowY + 27);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setTitle(title);
        window.setVisible(true);
        screenFactory = new ScreenFactory(this);
        GameThread gameThread = new GameThread(this);
        keyboardListener = new KeyboardListener();
        mousepadListener = new MousepadListener();
        window.add(gameThread);
        window.addKeyListener(keyboardListener);
        window.addMouseListener(mousepadListener);
        window.addMouseMotionListener(mousepadListener);
        new Thread(gameThread).start();
    }

    public static String projectPath()
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("");
        assert url != null;
        try
        {
            return url.toURI().getPath();
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
            return "somthing fucked up";
        }
    }

    public void setWindowSize(int X, int Y)
    {
        window.setSize(X + 6, Y + 27);
    }

    public double getWindowWidth()
    {
        return window.getWidth() - 6;
    }

    public double getWindowHeight()
    {
        return window.getHeight() - 27;
    }

    public Rectangle getWindowRect()
    {
        return new Rectangle(0, 0, (int) getWindowWidth(), (int) getWindowHeight());
    }

    public Color bacgroundColor()
    {
        return new Color(51, 51, 51);
    }

    public void setTitle(String title)
    {
        window.setTitle(title);
    }

    public void setSleep(int sleep)
    {
        this.sleep = sleep;
    }

    public KeyboardListener getKeyboardListener()
    {
        return keyboardListener;
    }

    public MousepadListener getMousepadListener()
    {
        return mousepadListener;
    }

    public ScreenFactory getScreenFactory()
    {
        return screenFactory;
    }

    public JFrame getWindow()
    {
        return window;
    }
}
