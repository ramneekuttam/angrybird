package com.chadgpt.angrybirds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.angrybirds.AngryBirds;

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
        drawButton(homebutton, 750, 500, 150, 150, x, y, () -> {
            this.dispose();
            game.setScreen(new MainScreen(game));
        });
        drawButton(levelbutton, 925, 500, 150, 150, x, y, () -> {
            this.dispose();
            game.setScreen(new LevelSelectScreen(game));
        });
        drawButton(reload, 1100, 500, 150, 150, x, y, () -> {
            this.dispose();
            game.setScreen(new GameScreen(game, 0));
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
