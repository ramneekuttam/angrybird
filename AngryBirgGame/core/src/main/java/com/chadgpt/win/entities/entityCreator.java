package com.chadgpt.win.entities;

import com.badlogic.gdx.physics.box2d.*;

//this follows factory Design pattern

public class entityCreator {
    //factory for wood class
    public static entity createWoodBlock(int id, float x, float y, World world) {
        if(id == 0){
            return createWood(x, y, 0.2f, 0.2f, world, 1, 7);
        }else if(id ==1){
            return createWood(x, y, 0.1f, 0.6f, world, 4, 8);
        }else if(id == 2){
            return createWood(x, y, 0.6f, 0.1f, world, 2, 9);
        }else if(id == 3){
            return createWood(x, y, 0.1f, 0.2f, world, 4, 10);
        }

        return null;
    }

    //factory for stone class
    public static entity createStoneBlock(int id, float x, float y, World world) {
        if(id == 0){
            return createStone(x, y, 0.2f, 0.2f, world, 1, 11);
        }else if(id ==1){
            return createStone(x, y, 0.2f, 0.6f, world, 4, 12);
        }else if(id == 2){
            return createStone(x, y, 0.6f, 0.1f, world, 2, 13);
        }else if(id == 3){
            return createStone(x, y, 0.1f, 0.2f, world, 4, 14);
        }

        return null;
    }

    //factory for ice glass
    public static entity createIceBlock(int id, float x, float y, World world) {
        if(id == 0){
            return createIce(x, y, 0.2f, 0.2f, world, 1, 15);
        }else if(id ==1){
            return createIce(x, y, 0.2f, 0.6f, world, 4, 16);
        }else if(id == 2){
            return createIce(x, y, 0.6f, 0.1f, world, 2, 17);
        }else if(id == 3){
            return createIce(x, y, 0.1f, 0.2f, world, 4, 18);
        }

        return null;
    }
    //factory for entity class
    public static entity entityCreator(int type, float x, float y, World world){
        switch (type){
            case 1:
                return createRedBird(x, y, world);
            case 2:
                return createBlueBird(x, y, world);
            case 3:
                return createYellowBird(x, y, world);
            case 4:
                return createBlackBird(x, y, world);
            case 5:
                return createJuniorPig(x, y, world);
            case 6:
                return createCorporalPig(x, y, world);
            case 7:
                return createKingPig(x, y, world);
        }
        return null;
    }

    public static entity createJuniorPig(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.15f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(5f);
        body.setAngularDamping(5f);

        circleShape.dispose();
        entityCreated = new juniorPig(body);
        return entityCreated;
    }
    public static entity createCorporalPig(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.3f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(10f);

        circleShape.dispose();
        entityCreated = new corporalPig(body);
        return entityCreated;
    }
    public static entity createKingPig(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.25f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(10f);
        circleShape.dispose();
        entityCreated = new kingPig(body);
        return entityCreated;
    }
    public static entity createRedBird(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.2f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(10f);
        circleShape.dispose();
        entityCreated = new redBird(body);
        return entityCreated;
    }
    public static entity createBlackBird(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.25f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(4f);
        circleShape.dispose();
        entityCreated = new blackBird(body);
        return entityCreated;
    }
    public static entity createYellowBird(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.2f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 1f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        body.setAngularDamping(5f);
        circleShape.dispose();
        entityCreated = new yellowBird(body);
        return entityCreated;
    }
    public static entity createBlueBird(float x, float y, World world) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(0.15f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.8f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.5f;
        body.createFixture(fixtureDef);
        circleShape.dispose();
        entityCreated = new blueBird(body);
        return entityCreated;
    }






    private static entity createWood(float x, float y, float width, float height, World world, int type, int type3) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.5f;
        body.createFixture(fixtureDef);
        shape.dispose();

        entityCreated = new woodBlock(body, width, height, type, type3);
        return entityCreated;
    }
    private static entity createStone(float x, float y, float width, float height, World world, int type, int type3) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0f;
        body.createFixture(fixtureDef);
        shape.dispose();

        entityCreated = new stoneBlock(body, width, height, type, type3);
        return entityCreated;
    }
    private static entity createIce(float x, float y, float width, float height, World world, int type, int type3) {
        entity entityCreated = null;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0f;
        body.createFixture(fixtureDef);
        shape.dispose();

        entityCreated = new iceBlock(body, width, height, type, type3);
        return entityCreated;
    }


}
