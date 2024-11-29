package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class juniorPig extends entity {
    public static Texture juniorPigTexture = new Texture("juniorpig.png");
    public static int initialHealth = 30
        ;
    public juniorPig(Body body) {
        super(body, null, initialHealth, 2, 4);
        Sprite tempSprite = new Sprite(juniorPigTexture);
        tempSprite.setSize(0.3f, 0.3f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
