package com.dumbpug.spriteanimationviewer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Viewer extends ApplicationAdapter {
	SpriteBatch batch;
	String sheetPath;
	int columns;
	int rows;
	float step;
	Animation animation;

	/**
	 * Create a new instance of the Viewer class.
	 * @param sheetPath
	 * @param columns
	 * @param rows
	 * @param step
	 */
	public Viewer(String sheetPath, int columns, int rows, float step) {
		this.sheetPath = sheetPath;
		this.rows      = rows;
		this.columns   = columns;
		this.step      = step;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		animation = new Animation(new Texture(sheetPath), columns, rows, step);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		TextureRegion currentAnimationFrame = animation.getCurrentFrame(true);
		
		batch.begin();
		batch.draw(currentAnimationFrame, 0, 0, currentAnimationFrame.getRegionWidth(), currentAnimationFrame.getRegionHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
