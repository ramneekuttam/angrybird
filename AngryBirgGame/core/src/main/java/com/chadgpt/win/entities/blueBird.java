package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class blueBird extends entity {
    public static Texture blackBirdTexture = new Texture("blue.png");
    public static int initialHealth = 300;
    public blueBird(Body body) {
        super(body, null, initialHealth, 0, 3, 1);
        Sprite tempSprite = new Sprite(blackBirdTexture);
        tempSprite.setSize(0.5f, 0.5f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
