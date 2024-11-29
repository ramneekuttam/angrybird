package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.chadgpt.win.database.database;

import java.util.ArrayList;

public class blackBird extends entity implements ability{
    public static Texture blackBirdTexture = new Texture("black.png");
    public static int initialHealth = 500;
    public blackBird(Body body) {
        super(body, null, initialHealth, 0, 1, 0);
        Sprite tempSprite = new Sprite(blackBirdTexture);
        tempSprite.setSize(0.5f, 0.5f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }

    @Override
    public void useAbility(World world, ArrayList<entity> entities) {
        Array<Body> bodies = new Array<>();
        world.getBodies(bodies);
        Vector2 position = body.getPosition();
        for (entity e : entities){
            if(e.body.getPosition().sub(position).len()<=2){
                e.health-=100;
            }
        }
    }

}
