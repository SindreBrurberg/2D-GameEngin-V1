package Engin.Entity;

import java.awt.*;


public interface IEntity {

    public double getWidth();

    public void setWidth(double Width);

    public double getHeight();

    public void setHeight(double Height);

    public double getX();

    public void setX(double x);

    public double getY();

    public void setY(double y);

    public void update();

    public void draw(Graphics2D g2d);
}
