package com.chadgpt.angrybirds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.angrybirds.AngryBirds;

public class PauseScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture resumebutton;
    private final Texture homebutton;
    private final Texture reloadbutton;
    private final Texture savebutton;
    private final int fac;
    public PauseScreen(AngryBirds game, int fac) {
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1080));
        background = new Texture("pausemenu.png");
        resumebutton = new Texture("ui/back.png");
        homebutton = new Texture("ui/menu.png");
        reloadbutton = new Texture("ui/reload.png");
        savebutton = new Texture("ui/savegame.png");
        this.fac = fac;
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
        drawButton(resumebutton, 100, 900, 100, 100, x, y, () ->{
            this.dispose();
            game.setScreen(new GameScreen(game, fac));
        });
        drawButton(reloadbutton, 600, 400, 200, 200, x, y, () ->{
            this.dispose();
            game.setScreen(new GameScreen(game, 1));
        });
        drawButton(savebutton, 900, 400, 200, 200, x, y, () ->{});
        drawButton(homebutton, 1200, 400, 200, 200, x, y, () ->{
            this.dispose();
            game.setScreen(new MainScreen(game));
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
        resumebutton.dispose();
        homebutton.dispose();
        reloadbutton.dispose();
        savebutton.dispose();
        stage.dispose();
    }
}
