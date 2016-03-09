package Engin.Entity;

import java.awt.*;


public interface IEntity {

	double getWidth();

	void setWidth(double Width);

	double getHeight();

	void setHeight(double Height);

	double getX();

	void setX(double x);

	double getY();

	void setY(double y);

	void update();

	void draw(Graphics2D g2d);
}
