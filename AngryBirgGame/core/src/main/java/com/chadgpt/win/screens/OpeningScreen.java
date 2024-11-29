package com.chadgpt.win.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.win.AngryBirds;
public class OpeningScreen implements Screen {
    final AngryBirds game;
    private Stage stage;
    private final Texture background;

    public OpeningScreen(AngryBirds game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        this.background = new Texture("loading_screen.png");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
        ScreenUtils.clear(0, 0, 0, 0);
        stage.getBatch().begin();
        if(Gdx.input.justTouched()){
            this.dispose();
            game.setScreen(new MainScreen(game));
        }else{
            stage.getBatch().draw(background, 0, 0, 1920, 1080);
        }
        stage.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        stage.dispose();
    }
}
