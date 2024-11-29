package com.chadgpt.win.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.win.AngryBirds;
import com.chadgpt.win.database.database;
import com.chadgpt.win.methods.methods;

public class MainScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture playbutton;
    private final Texture loadbutton;
    private final Texture exitbutton;
    private final Texture sandboxbutton;
    private Texture soundbutton;
    private static boolean counter;
    private final Sound sound;
    public MainScreen(AngryBirds game) {
        this.game = game;
        stage = new Stage(new StretchViewport(1920, 1080));
        background = new Texture("mainscreenbackground.png");
        playbutton = new Texture("ui/playbutton.png");
        loadbutton = new Texture("ui/loadbutton.png");
        exitbutton = new Texture("ui/exitbutton.png");
        soundbutton = new Texture("ui/soundon.png");
        sandboxbutton = new Texture("ui/sandbox.png");
        counter = true;
        sound = Gdx.audio.newSound(Gdx.files.internal("sounds/bgm.mp3"));
        sound.loop();
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
        methods.drawButton(stage.getBatch(), sandboxbutton, 1300, 400, 150, 150, x, y, () ->{
            database.currentLevel = 3;
            sound.dispose();
            game.setScreen(new GameScreen());
        });
        methods.drawButton(stage.getBatch(), playbutton, 725, 500, 450, 125, x, y, () ->{
            sound.dispose();
            database.currentLevel = 0;
            game.setScreen(new LevelSelectScreen(game));
        });
        methods.drawButton(stage.getBatch(), loadbutton, 725, 350, 450, 125, x, y, () ->{
            sound.dispose();
            game.setScreen(new SaveGameLoad());
//            game.setScreen(new LoadLevel(game));
        });
        methods.drawButton(stage.getBatch(), exitbutton, 725, 200, 450, 125, x, y, () ->{
//            this.dispose();
            Gdx.app.exit();
        });
        methods.drawButton(stage.getBatch(), soundbutton, 200, 200, 200, 200, x, y, () ->{
            if(counter) {
                soundbutton = new Texture("ui/nosound.png");
                sound.stop();
                counter = false;
            }else{
                soundbutton = new Texture("ui/soundon.png");
                sound.loop();
                counter = true;
            }
        });



        stage.getBatch().end();
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        playbutton.dispose();
        loadbutton.dispose();
        exitbutton.dispose();
        sound.dispose();
        stage.dispose();
    }
}
