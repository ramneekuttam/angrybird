package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Queue;

public class catapult {
    public static Texture catapult = new Texture("assets/catapult.png");
    public Body body;

    public static void shoot(Vector2 force, int scale, Body body) {
        body.setLinearVelocity(force.scl(scale));
    }

    public static Texture getTexture(){
        return catapult;
    }

    public static Body createCatapult(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(new Vector2(2f, 1.65f));
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.3f, 0.1f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0f;
        body.createFixture(fixtureDef);
        shape.dispose();
        return body;
    }
}
