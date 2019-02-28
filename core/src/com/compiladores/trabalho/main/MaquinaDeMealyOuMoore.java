package com.compiladores.trabalho.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.compiladores.trabalho.managers.GameStateManager;

public class MaquinaDeMealyOuMoore extends ApplicationAdapter {

	public static int WIDTH;
	public static int HEIGHT;
	public static OrthographicCamera camera;

	private GameStateManager gsm;

	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.translate(WIDTH / 2, HEIGHT / 2);
		camera.update();

		gsm = new GameStateManager();
		//batch = new SpriteBatch();
		//img = new Texture("core/assets/badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.85f, 0.85f, 0.85f, 1.0f);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();


		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
