package Engin.Core;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class GameThread extends JPanel implements Runnable {
    private static final long serialVersionUID = 2551158487608353974L;
    private final Game game;

    public GameThread(Game game)
    {
        this.game = game;
        setFocusable(true);
    }

    @Override
    public void run()
    {
        //noinspection InfiniteLoopStatement
        while (true)
        {
            try
            {
                if (game.getScreenFactory().getCurrentScreen() != null && game.getScreenFactory().getCurrentScreen().created)
                {
                    game.getScreenFactory().getCurrentScreen().onUpdate();
                }
                Thread.sleep(game.sleep);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (game.getScreenFactory().getCurrentScreen() != null && game.getScreenFactory().getCurrentScreen().created)
        {
            g2d.setPaint(game.getScreenFactory().getGame().bacgroundColor());
            g2d.fill(game.getScreenFactory().getGame().getWindowRect());
            game.getScreenFactory().getCurrentScreen().onDraw(g2d);
        }
        repaint();
    }
}
