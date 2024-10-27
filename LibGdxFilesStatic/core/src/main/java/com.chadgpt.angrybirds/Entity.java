package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    protected Texture texture;
    protected float x, y;
    protected boolean isDestroyed;

    public Entity(Texture texture, float x, float y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.isDestroyed = false;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // Getter and setter for destroyed state
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.isDestroyed = destroyed;
    }


}

