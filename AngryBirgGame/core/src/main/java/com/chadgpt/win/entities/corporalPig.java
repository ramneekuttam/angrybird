package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class corporalPig extends entity {
    public static Texture CorporalPigTexture = new Texture("corporalpig.png");
    public static int initialHealth = 40;
    public corporalPig(Body body) {
        super(body, null, initialHealth, 2, 5);
        Sprite tempSprite = new Sprite(CorporalPigTexture);
        tempSprite.setSize(0.5f, 0.5f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
