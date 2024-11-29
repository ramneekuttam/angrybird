package com.chadgpt.win.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.win.AngryBirds;
import com.chadgpt.win.database.GameSaver;
import com.chadgpt.win.database.database;
import com.chadgpt.win.methods.methods;

public class LoadLevel implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture loadlevel1;
    private final Texture loadlevel2;
    private final Texture loadlevel3;
    private final Texture homebutton;
    public LoadLevel(AngryBirds game){
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1080));
        background = new Texture("game.png");
//        loadlevel = new Texture("ui/level_box.png");
        loadlevel1 = new Texture("ui/level1save.png");
        loadlevel2 = new Texture("ui/level2save.png");
        loadlevel3 = new Texture("ui/level3save.png");
        homebutton = new Texture("ui/menu.png");
        database.mainaudio.loop();
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

        methods.drawButton(stage.getBatch(), loadlevel1, 850, 400, 500, 300, x, y, () ->{
            database.mainaudio.stop();
            game.setScreen(new SaveGameLoad());
        });

        methods.drawButton(stage.getBatch(), homebutton, 100, 900, 100, 100, x, y, () ->{
            this.dispose();
            database.mainaudio.stop();
            game.setScreen(new MainScreen(game));
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
        homebutton.dispose();
//        loadlevel.dispose();
        loadlevel1.dispose();
        loadlevel2.dispose();
        loadlevel3.dispose();
        stage.dispose();
    }
}
