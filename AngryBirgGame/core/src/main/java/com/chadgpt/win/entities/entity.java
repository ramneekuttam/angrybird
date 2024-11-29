package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class entity {
    public Body body;
    public Sprite sprite;
    public int health;
    public int type;
    public int type2;
    public int type3;
    public entity(Body body, Sprite sprite, int health, int type, int type3) {
        this.body = body;
        this.sprite = sprite;
        this.health = health;
        this.type = type;
        this.type3 = type3;
    }
    public entity(Body body, Sprite sprite, int health, int type, int type2, int type3) {
        this.body = body;
        this.sprite = sprite;
        this.health = health;
        this.type = type;
        this.type2 = type2;
        this.type3 = type3;
    }
    public void handleCollision(int damage){
        this.health -= damage;
    }
}
