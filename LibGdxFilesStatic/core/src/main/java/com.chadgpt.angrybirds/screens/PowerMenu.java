package com.chadgpt.angrybirds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.angrybirds.AngryBirds;

public class PowerMenu implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture resumebutton;
    private final int fac;
    private final Texture power1;
    private final Texture power2;
    private final Texture power3;
    private final Texture power4;
    public PowerMenu(AngryBirds game, int fac) {
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1080));
        background = new Texture("powerbackground.png");
        resumebutton = new Texture("ui/back.png");
        power1 = new Texture("ui/power1.png");
        power2 = new Texture("ui/power2.png");
        power3 = new Texture("ui/power3.png");
        power4 = new Texture("ui/power5.png");
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
        drawButton(power1, 750, 500, 200, 200,x, y, () -> {});
        drawButton(power2, 750, 300, 200, 200,x, y, () -> {});
        drawButton(power3, 1050, 500, 200, 200,x, y, () -> {});
        drawButton(power4, 1050, 300, 200, 200,x, y, () -> {});

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
        stage.dispose();
    }
}
