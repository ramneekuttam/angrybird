package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class kingPig extends entity {
    public static Texture kingPigTexture = new Texture("kingpig.png");
    public static int initialHealth = 50;
    public kingPig(Body body) {
        super(body, null, initialHealth, 2, 6);
        Sprite tempSprite = new Sprite(kingPigTexture);
        tempSprite.setSize(0.6f, 0.6f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
