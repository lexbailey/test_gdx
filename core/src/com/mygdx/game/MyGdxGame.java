package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    Bouncer b;
    OrthographicCamera camera;
	
	@Override
	public void create () {
        camera = new OrthographicCamera(100,100);
		batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
		img = new Texture("dvd.png");
        b = new Bouncer(100,100, 2.0f);
	}

    @Override
    public void resize (int w, int h){
        b.resize(w-512,h-307);
        camera.position.set(w/2,h/2,0);
        camera.viewportWidth = w;
        camera.viewportHeight = h;
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

	@Override
	public void render () {
		ScreenUtils.clear(0.2f, 0.2f, 0.9f, 1.0f);
        b.step(1.0f);
		batch.begin();
		batch.draw(img, b.get_pos_x(), b.get_pos_y());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
