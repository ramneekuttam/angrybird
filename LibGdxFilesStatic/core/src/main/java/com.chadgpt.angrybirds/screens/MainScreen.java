package com.chadgpt.angrybirds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.angrybirds.AngryBirds;

public class MainScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture playbutton;
    private final Texture loadbutton;
    private final Texture exitbutton;
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

        drawButton(playbutton, 725, 500, 450, 125, x, y, () ->{
            System.out.println("Hey");
            this.dispose();
            game.setScreen(new LevelSelectScreen(game));
        });
        drawButton(loadbutton, 725, 350, 450, 125, x, y, () ->{
            System.out.println("Hii");
            this.dispose();
            game.setScreen(new LoadLevel(game));
        });
        drawButton(exitbutton, 725, 200, 450, 125, x, y, () ->{
            System.out.println("Hola");
            Gdx.app.exit();
        });
        drawButton(soundbutton, 200, 200, 200, 200, x, y, () ->{
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

    private void drawButton(Texture normalTexture,float x, float y, float width, float height, int mouseX, int mouseY, Runnable onClick) {
        // Check if the mouse is over the button
        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

        // Draw the appropriate texture
        if (isHovered) {
            stage.getBatch().draw(normalTexture, x, y, width+50, height+30);
            if (Gdx.input.justTouched()) {
                onClick.run(); // Execute the click action
            }
        } else {
            stage.getBatch().draw(normalTexture, x, y, width, height);
        }
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
