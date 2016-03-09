package Engin;

import Engin.Core.Game;

/**
 * Created with IntelliJ IDEA.
 * User: Haxer
 * Date: 23.11.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class ScreenFactory {

	private final Game game;
	private Screen screen;

	public ScreenFactory(Game game) {
		this.game = game;
	}

	public void showScreen(Screen screen) {
		this.screen = screen;
		this.screen.onCreate();
		this.screen.created = true;
	}

	public Screen getCurrentScreen() {
		return screen;
	}

	public Game getGame() {
		return game;
	}
}
