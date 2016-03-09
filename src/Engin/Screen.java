package Engin;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public abstract class Screen {

	public static ScreenFactory screenFactory;
	public boolean created = false;

	public Screen(ScreenFactory screenFactory) {
		Screen.screenFactory = screenFactory;
	}

	public static ScreenFactory getScreenFactory() {
		return screenFactory;
	}

	public abstract void onCreate();

	public abstract void onUpdate();

	public abstract void onDraw(Graphics2D g2d);

	public Rectangle screen() {
		return new Rectangle(0, 0, (int) screenFactory.getGame().getWindowWidth(),
				(int) screenFactory.getGame().getWindowHeight());
	}

}
