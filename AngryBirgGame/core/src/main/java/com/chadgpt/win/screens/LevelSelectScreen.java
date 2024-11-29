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

public class LevelSelectScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture level1;
    private final Texture level2;
    private final Texture level3;
    private final Texture menubutton;
    public LevelSelectScreen(AngryBirds game){
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1080));
        background = new Texture("level_select.png");
        level1 = new Texture("ui/level1.png");
        level2 = new Texture("ui/level2.png");
        level3 = new Texture("ui/level3.png");
        menubutton = new Texture("ui/menu.png");
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

        methods.drawButton(stage.getBatch(), level1, 400, 400, 400, 250, x, y, () ->{
//            this.dispose();
            database.currentLevel = 0;
            game.setScreen(new GameScreen());
        });

        methods.drawButton(stage.getBatch(), level2, 850, 400, 400, 250, x, y, () ->{
//            this.dispose();
            database.currentLevel = 1;
            game.setScreen(new GameScreen());
        });

        methods.drawButton(stage.getBatch(), level3, 1300, 400, 400, 250, x, y, () ->{
//            this.dispose();
            database.currentLevel = 2;
            game.setScreen(new GameScreen());
        });

        methods.drawButton(stage.getBatch(), menubutton, 100, 900, 100, 100, x, y, () ->{
            this.dispose();
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
        background.dispose();
        level1.dispose();
        level2.dispose();
        level3.dispose();
        menubutton.dispose();
        stage.dispose();
    }
}
