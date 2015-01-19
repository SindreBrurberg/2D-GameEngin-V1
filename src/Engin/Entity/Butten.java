package Engin.Entity;

import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;

/**
 * Created by Haxer on 10.02.14.
 */
public abstract class Butten extends AbstractEntity implements IButten {
    public static Rectangle[] buttens;
    private static StringTxt stringTxt;
    private static boolean maxRess, minRess;
    protected double Width, Height;
    private String TXT;
    private ScreenFactory screenFactory;
    private boolean deactivated = false, keepActivated = false;
    private Rectangle[] outline = new Rectangle[10];

    public Butten(double x, double y, double Width, double Height, String TXT, ScreenFactory screenFactory, boolean isDisabled)
    {
        super(x, y);
        this.Width = Width;
        this.Height = Height;
        this.TXT = TXT;
        this.screenFactory = screenFactory;
        this.deactivated = isDisabled;
    }

    public Butten(Rectangle butten, String TXT, ScreenFactory screenFactory, boolean isDisabled)
    {
        super(butten.getX(), butten.getY());
        this.Width = butten.getWidth();
        this.Height = butten.getHeight();
        this.TXT = TXT;
        this.screenFactory = screenFactory;
        this.deactivated = isDisabled;
    }

    public Butten(Rectangle butten, String TXT, ScreenFactory screenFactory)
    {
        this(butten, TXT, screenFactory, false);
    }

    public Butten(Rectangle butten, ScreenFactory screenFactory)
    {
        this(butten, "", screenFactory, false);
    }

    public Butten(int X, int Y, int Width, int Height, ScreenFactory screenFactory)
    {
        this(new Rectangle(X, Y, Width, Height), "", screenFactory, false);
    }

    public Butten(int X, int Y, int Width, int Height, String TXT, ScreenFactory screenFactory)
    {
        this(new Rectangle(X, Y, Width, Height), TXT, screenFactory, false);
    }

    public static void generateButtons(int sideGap, int gap, int intX, int intY, int maxWidth, int maxHeight, int buttensTot, boolean oldAlgo)
    {
        generateButtons(sideGap, gap, intX, intY, maxWidth, maxHeight, buttensTot, 0, oldAlgo);
    }

    public static void generateButtons(int sideGap, int gap, int intX, int intY, int maxWidth, int maxHeight, int buttensTot)
    {
        generateButtons(sideGap, gap, intX, intY, maxWidth, maxHeight, buttensTot, 0, false);
    }

    public static void generateButtons(int sideGap, int gap, int intX, int intY, int maxWidth, int maxHeight, int buttensTot, int forceCollumns)
    {
        generateButtons(sideGap, gap, intX, intY, maxWidth, maxHeight, buttensTot, forceCollumns, false);
    }

    public static void generateButtons(int sideGap, int gap, int intX, int intY, int maxWidth, int maxHeight, int buttensTot, int forceCollumns, boolean oldAlgo)
    {
        Rectangle[] buttens = new Rectangle[buttensTot];
        int collumns, rawsTot, buttenX = 0, buttenY = 0, buttenWidth, buttenHeight, x = intX + sideGap, y = intY + sideGap;
        boolean collumn2 = buttensTot % 2 == 0 && buttensTot > 2, collumn3 = buttensTot % 3 == 0 && buttensTot > 6;
        if (collumn3)
        {
            collumns = 3;
        } else if (collumn2)
        {
            collumns = 2;
        } else
        {
            collumns = 1;
        }
        if (forceCollumns != 0)
        {
            collumns = forceCollumns;
        }
        if (buttensTot % collumns == 0.0)
        {
            rawsTot = buttensTot / collumns;
        } else if (buttensTot + 1 % collumns == 0.0)
        {
            rawsTot = (buttensTot + 1) / collumns;
        } else
        {
            rawsTot = (buttensTot + 2) / collumns;
        }
        buttenWidth = (maxWidth - sideGap * 2 - gap * (collumns - 1)) / collumns;
        if (!oldAlgo)
            buttenHeight = ((maxHeight - intY - sideGap * 2) - gap * (rawsTot - 1)) / rawsTot;
        else
            buttenHeight = (maxHeight - sideGap * 2 - gap * (rawsTot - 1)) / rawsTot;
        for (int i = 0, r = 1, c = 0; i < buttensTot; i++)
        {
            //System.out.println("start" + "\t" + c + "\t" + r + "\t" + i);
            if (c == collumns)
            {
                r++;
                c = 1;
            } else
            {
                c++;
            }
            //System.out.println("mid" + "\t" + c + "\t" + r + "\t" + i);
            if (r == 1)
                buttenY = y;
            else if (i - collumns >= 0)
            {
                buttenY = buttens[i - collumns].y + buttens[i - collumns].height + gap;
            }
            if (c == 1)
                buttenX = x;
            else if (i > 0)
            {
                buttenX = buttens[i - 1].x + buttens[i - 1].width + gap;
            }
            buttens[i] = new Rectangle(buttenX, buttenY, buttenWidth, buttenHeight);
            //System.out.println("end" + "\t" + c + "\t" + r + "\t" + i);
        }
        Butten.buttens = buttens;
    }

    public static void RessUp(ScreenFactory screenFactory)
    {
        if (screenFactory.getGame().getWindow().getWidth() == 806 && screenFactory.getGame().getWindow().getHeight() == 627)
        {
            Screen.getScreenFactory().getGame().setWindowSize(1152, 648);
            minRess = false;
        } else if (screenFactory.getGame().getWindow().getWidth() == 1152 + 6 && screenFactory.getGame().getWindow().getHeight() == 648 + 27)
        {
            Screen.getScreenFactory().getGame().setWindowSize(1280, 720);
            minRess = false;
        } else if (screenFactory.getGame().getWindow().getWidth() == 1280 + 6 && screenFactory.getGame().getWindow().getHeight() == 720 + 27)
        {
            Screen.getScreenFactory().getGame().setWindowSize(1600, 900);
            maxRess = true; /**
         } else if (screenFactory.getGame().getWindow().getWidth() == 1600 + 6 && screenFactory.getGame().getWindow().getHeight() == 900 + 27){
         Screen.getScreenFactory().getGame().setWindowSize(1980, 1080);
         maxRess = true; */
        }
    }

    public static void RessDown(ScreenFactory screenFactory)
    {
        if (screenFactory.getGame().getWindow().getWidth() == 1280 + 6 && screenFactory.getGame().getWindow().getHeight() == 720 + 27)
        {
            Screen.getScreenFactory().getGame().setWindowSize(1152, 648);
            maxRess = false;
        } else if (screenFactory.getGame().getWindow().getWidth() == 1600 + 6 && screenFactory.getGame().getWindow().getHeight() == 900 + 27)
        {
            Screen.getScreenFactory().getGame().setWindowSize(1280, 720);
            maxRess = false; /**
         } else if (screenFactory.getGame().getWindow().getWidth() == 1980 + 6 && screenFactory.getGame().getWindow().getHeight() == 1092) {
         Screen.getScreenFactory().getGame().setWindowSize(1600, 900);
         maxRess = false; */
        } else if (screenFactory.getGame().getWindow().getWidth() == 1152 + 6 && screenFactory.getGame().getWindow().getHeight() == 648 + 27)
        {
            Screen.getScreenFactory().getGame().setWindowSize(800, 600);
            minRess = true;
        }
    }

    public static void generateTxtRess(Rectangle[] ressButtens, ScreenFactory screenFactory)
    {
        stringTxt = new StringTxt(ressButtens[0].getX() + ressButtens[0].getWidth() + 40, ressButtens[0].getY(), ressButtens[1].getX() - (ressButtens[0].getX() + ressButtens[0].getWidth() + 60), ressButtens[0].getHeight(), String.valueOf(screenFactory.getGame().getWindow().getWidth() - 6) + "X" + String.valueOf(screenFactory.getGame().getWindow().getHeight() - 27)) {
            @Override
            public void onUpdate()
            {

            }
        };
    }

    public static void UpdateTxtRess()
    {
        stringTxt.update();
    }

    public static void DrawTxtRess(Graphics2D g2d)
    {
        stringTxt.draw(g2d);
    }

    public static boolean getMaxRess()
    {
        return maxRess;
    }

    public static void setMaxRess(boolean maxRess)
    {
        Butten.maxRess = maxRess;
    }

    public static boolean getMinRess()
    {
        return minRess;
    }

    public static void setMinRess(boolean minRess)
    {
        Butten.minRess = minRess;
    }

    public void setHeight(int height)
    {
        this.Height = height;
    }

    public void setWidth(int width)
    {
        this.Width = width;
    }

    public String getTXT()
    {
        return TXT;
    }

    public void setTXT(String TXT)
    {
        this.TXT = TXT;
    }

    public void setDiactivated(boolean deactivated)
    {
        this.deactivated = deactivated;
    }

    public void setKeepActivated(boolean keepActivated)
    {
        this.keepActivated = keepActivated;
    }

    private Rectangle getBounds()
    {
        return new Rectangle((int) getX(), (int) getY(), (int) Width, (int) Height);
    }

    private Rectangle getHitBounds()
    {
        return new Rectangle((int) getX(), (int) getY(), (int) Width, (int) Height);
    }

    public boolean isHighlighted()
    {
        return getHitBounds().intersects(screenFactory.getGame().getMousepadListener().getMouse(screenFactory));
    }

    private void outline()
    {
        for (int i = 0; i < outline.length; i++)
        {
            outline[i] = new Rectangle((int) getBounds().getX() + i, (int) getBounds().getY() + i, (int) getBounds().getWidth() - i * 2, (int) getBounds().getHeight() - i * 2);
        }
    }

    public void testActive()
    {
        if (isActive())
        {
            for (int i = 0; i <= 300; i++)
            {
                if (i == 300)
                {
                    System.out.println("reset");
                    screenFactory.getGame().getMousepadListener().resetMousePressed();
                }
            }
        }
    }

    public boolean isActive()
    {
        return isHighlighted() && screenFactory.getGame().getMousepadListener().isMousePressed();
    }

    public static void ressButtenToggler(Butten ressButten1, Butten ressButten2){
        if (Butten.getMaxRess())
            ressButten1.setDiactivated(true);
        else ressButten1.setDiactivated(false);
        if (Butten.getMinRess())
            ressButten2.setDiactivated(true);
        else ressButten2.setDiactivated(false);
    }

    @Override
    public void update()
    {
        if (isActive())
        {
            screenFactory.getGame().getMousepadListener().resetMousePressed();
            if (!deactivated)
                isPushed();
        }
        if (deactivated)
            setKeepActivated(false);
    }

    @Override
    public void draw(Graphics2D g2d)
    {
        outline();
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext frc = g2.getFontRenderContext();
        Font font = g2.getFont().deriveFont(16f);
        g2.setFont(font);
        double sw = font.getStringBounds(TXT, frc).getWidth() + 10;
        LineMetrics lm = font.getLineMetrics(TXT, frc);
        double sh = lm.getAscent() + lm.getDescent();
        Rectangle r = outline[outline.length - 1];
        if (!deactivated)
        {
            if (isHighlighted() || keepActivated)
            {
                g2.setPaint(Color.orange.brighter());
                g2.fill(r);
                g2.setPaint(Color.orange);
                for (Rectangle anOutline : outline)
                {
                    g2.draw(anOutline);
                }
            } else
            {
                g2.setPaint(Color.orange);
                g2.fill(r);
                g2.setPaint(Color.orange.darker());
                for (Rectangle anOutline : outline)
                {
                    g2.draw(anOutline);
                }
            }
        } else
        {
            g2.setPaint(Color.gray);
            g2.fill(r);
            g2.setPaint(Color.gray.darker());
            for (Rectangle anOutline : outline)
            {
                g2.draw(anOutline);
            }
        }
        g2.setPaint(Color.BLACK);
        double xScale = r.width / sw;
        double yScale = r.height / sh;
        double x = r.x + xScale * (r.width + 5 - xScale * sw) / 2;
        double y = r.getMaxY() - yScale * lm.getDescent();
        AffineTransform at =
                AffineTransform.getTranslateInstance(x, y);
        at.scale(xScale, yScale);
        g2.setFont(font.deriveFont(at));
        g2.drawString(TXT, 0, 0);
    }
}
