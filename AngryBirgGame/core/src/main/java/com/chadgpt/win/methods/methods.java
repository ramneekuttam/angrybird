package com.chadgpt.win.methods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class methods {
    public static void drawButton(SpriteBatch batch, Texture normalTexture, float x, float y, float width, float height, float mouseX, float mouseY, Runnable onClick) {
        // Check if the mouse is over the button
        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
        if (isHovered) {
            batch.draw(normalTexture, x, y, width+0.2f, height+0.2f);
            if (Gdx.input.justTouched()) {
                onClick.run();
            }
        } else {
            batch.draw(normalTexture, x, y, width, height);
        }
    }
    public static void drawButton(Batch batch, Texture normalTexture, float x, float y, float width, float height, float mouseX, float mouseY, Runnable onClick) {
        // Check if the mouse is over the button
        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
        if (isHovered) {
            batch.draw(normalTexture, x, y, width+50f, height+30f);
            if (Gdx.input.justTouched()) {
                onClick.run();
            }
        } else {
            batch.draw(normalTexture, x, y, width, height);
        }
    }
    public static boolean isInsideDragArea(Vector2 touch, Vector2 dragAreaCenter, float dragAreaRadius) {
        return touch.dst(dragAreaCenter) <= dragAreaRadius;
    }
}
