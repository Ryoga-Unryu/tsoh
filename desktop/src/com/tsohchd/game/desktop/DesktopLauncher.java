package com.tsohchd.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tsohchd.game.TheStoryOfHeroes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.foregroundFPS = 120;
		config.useHDPI = true;
		config.resizable = false;
		new LwjglApplication(new TheStoryOfHeroes(), config);
	}
}
