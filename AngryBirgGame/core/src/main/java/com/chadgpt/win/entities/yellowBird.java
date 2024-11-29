package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class yellowBird extends entity implements ability{
    public static Texture blackBirdTexture = new Texture("yellowbird.png");
    public static int initialHealth = 500;
    public yellowBird(Body body) {
        super(body, null, initialHealth, 0, 2, 3);
        Sprite tempSprite = new Sprite(blackBirdTexture);
        tempSprite.setSize(0.5f, 0.5f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }

    @Override
    public void useAbility(World world, ArrayList<entity> entities) {
        System.out.println("yellowabilityused");
        body.setLinearVelocity(body.getLinearVelocity().scl(1.5f));
    }
}
