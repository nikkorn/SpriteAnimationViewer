package com.dumbpug.spriteanimationviewer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Viewer extends ApplicationAdapter {
	SpriteBatch batch;
	String sheetPath;

	public Viewer(String sheetPath, int columns, int rows, float step) {

	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
