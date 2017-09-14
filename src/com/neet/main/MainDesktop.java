package com.neet.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MainDesktop {
	
	public static void main(String[] args){
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Gaimu";
		cfg.width = 480;
		cfg.height = 510;
		cfg.useGL30 = true;
		cfg.resizable = false;
		new LwjglApplication(new Game(), cfg);
	}

}
