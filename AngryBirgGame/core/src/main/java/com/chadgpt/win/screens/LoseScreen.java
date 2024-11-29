package com.chadgpt.win.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.win.AngryBirds;
import com.chadgpt.win.database.database;
import com.chadgpt.win.methods.methods;

public class LoseScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture homebutton;
    private final Texture reload;
    private final Texture levelbutton;

    public LoseScreen(AngryBirds game){
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1080));
        background = new Texture("losescreen.png");
        homebutton = new Texture("ui/menu.png");
        reload = new Texture("ui/reload.png");
        levelbutton = new Texture("ui/levelselect.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
        ScreenUtils.clear(0, 0, 0, 0);
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Convert y-coordinate
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 1980, 1080);
        methods.drawButton(stage.getBatch(), homebutton, 750, 500, 150, 150, x, y, () -> {
            this.dispose();
            game.setScreen(new MainScreen(game));
        });
        methods.drawButton(stage.getBatch(), levelbutton, 925, 500, 150, 150, x, y, () -> {
            this.dispose();
            game.setScreen(new LevelSelectScreen(game));
        });
        methods.drawButton(stage.getBatch(), reload, 1100, 500, 150, 150, x, y, () -> {
//            game.setScreen(new GameScreen());
            database.game.setScreen(new GameScreen());
//            this.dispose();

        });
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
        homebutton.dispose();
        reload.dispose();
        levelbutton.dispose();
        stage.dispose();
    }
}
