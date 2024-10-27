package com.chadgpt.angrybirds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chadgpt.angrybirds.screens.OpeningScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class AngryBirds extends Game {
    public SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new OpeningScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
