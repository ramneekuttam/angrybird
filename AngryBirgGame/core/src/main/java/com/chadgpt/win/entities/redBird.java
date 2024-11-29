package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;

public class redBird extends entity {
    public static Texture redBirdTexture = new Texture("bird1.png");
    public static int initialHealth = 300;
    public redBird(Body body) {
        super(body, null, initialHealth, 0, 0, 2);
        Sprite tempSprite = new Sprite(redBirdTexture);
        tempSprite.setSize(0.4f, 0.4f);
//        tempSprite.setOriginCenter();
//        tempSprite.setPosition(1, 1);
        tempSprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }

    @Override
    public void handleCollision(int damage){
        this.health -= damage;
        //this willd estroy body
        if(this.health <= 0){
            this.type = -1;
        }
    }

    public void handleCollision(int damage, int factor){
        this.health -= damage * factor;
        if(this.health <= 0){
            this.type = -1;
        }
    }
}
