package com.chadgpt.win.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.chadgpt.win.entities.entity;
import com.chadgpt.win.database.database;
import com.chadgpt.win.database.GameLoader;
import com.chadgpt.win.database.GameSaver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import com.chadgpt.win.entities.catapult;
import com.chadgpt.win.entities.blackBird;
import com.chadgpt.win.entities.yellowBird;
import com.chadgpt.win.methods.GameLogic;
import com.chadgpt.win.methods.methods;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SaveGameLoad implements Screen {

    //world variables
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;

    //world graphic related variables
    private Texture backgroundTexture;

    //playing related variable
    private Body currentActiveBird;
    private ArrayList<entity> entities;
    private ArrayList<Body> allBirdList;
    private Queue<Body> allBirdQueue;
    private ArrayList<Body> allPigList;
    private Body currentFlyingBird;
    private entity currentFlyingEntity;
    private boolean temp = true;
    //dragging related variables;
    private Vector2 dragStart;
    private boolean isDragging;
    private Vector2 dragAreaCenter = new Vector2(2, 2);
    private float dragAreaRadius = 0.5f;
    private boolean flag = false;
    private float birdSetTime = 0f;
    private float birdDelay = 2f;
    private boolean flag2 = true;
    private float timetowin = 0;
    @Override
    public void show() {
        //basic variable initialization
        world = new World(new Vector2(0, -9.81f), true);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 16, 9);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();


        //setupinput handler
        setupInputHandler();
        setupContactListner();
        //create border
        createBorder();
        //other initialization
        entities = new ArrayList<>();
        allBirdQueue = new LinkedList<>();
        allPigList = new ArrayList<>();
        currentFlyingBird = null;
        catapult.createCatapult(world);

        //here we need to add logic to restore the state
        //things to do create new entities you can start with and strctures
        //entitties addition + allbirdquuee + allpig list
        //well there is a problem that bird is flying or bird is still there so solution is that if bird is in all birdqueue mark them as not flying one and then they need to be added to all bird queue
        //you can add for current flying bird also -1 represnt that should not be in all bird queue
        //logic for currentflying later; so we did svae game
        GameLoader.loadWorld(world, "gamesave.bin", entities, allBirdQueue, allPigList);
        System.out.println("The size of all bird queue is: " + allBirdQueue.size());
        currentActiveBird = allBirdQueue.peek();
        currentActiveBird.setLinearVelocity(0, 0);
        currentActiveBird.setAngularVelocity(0);
        currentActiveBird.setTransform(2, 2, 0);
    }

    @Override
    public void render(float delta) {

        birdSetTime += delta;
        if(birdSetTime>=birdDelay && flag && !allBirdQueue.isEmpty()){
            birdSetTime=0f;
            currentActiveBird = allBirdQueue.peek();
            currentActiveBird.setTransform(2, 2, 0);
            currentActiveBird.setLinearVelocity(0, 0);
            currentActiveBird.setAngularVelocity(0);
            flag = false;
        }
        currentActiveBird = allBirdQueue.peek();
        if(allBirdQueue.isEmpty() || allPigList.isEmpty()){
            timetowin+=delta;
            if(timetowin>=5 && flag2){
                flag2 = false;
                if(GameLogic.checkWinCondition(allPigList)){
                    this.dispose();
                    database.game.setScreen(new WinScreen(database.game));
                }else{
                    this.dispose();
                    database.game.setScreen(new LoseScreen(database.game));
                }
            }
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta, 12, 20);
        camera.update();
        debugRenderer.render(world, camera.combined);

        //spriteBatch
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(database.getBackground(), 0, 0, 16, 9);
        batch.draw(catapult.getTexture(), 1.65f, 1, 0.75f,    1.25f);
        methods.drawButton(batch, database.backbutton, 1, 7.75f, 1, 1, getCoords().x, getCoords().y, ()->{
            database.game.setScreen(new MainScreen(database.game));

        });
        methods.drawButton(batch, database.reloadbutton, 2, 7.75f, 1, 1, getCoords().x, getCoords().y, ()->{
            database.game.setScreen(new GameScreen());
//            this.dispose();
        });
        methods.drawButton(batch, database.savebutton, 3, 7.75f, 1, 1, getCoords().x, getCoords().y, ()->{
            GameSaver.saveWorld(entities, "gamesave.bin", allBirdQueue, allPigList);

        });
        if(Gdx.input.justTouched()){
            System.out.println("The getCoordis  is " + (int)getCoords().x + "=" + (int)getCoords().y);
        }
        for (int i = entities.size() - 1; i >= 0; i--) {
            entity tempEntity = entities.get(i);
            tempEntity.sprite.setPosition(tempEntity.body.getPosition().x - tempEntity.sprite.getWidth() / 2, tempEntity.body.getPosition().y - tempEntity.sprite.getHeight() / 2);
            tempEntity.sprite.setRotation((float) Math.toDegrees(tempEntity.body.getAngle()));
            tempEntity.sprite.draw(batch);

            if(tempEntity.health <=0){
                world.destroyBody(tempEntity.body);
                entities.remove(i);
                if(tempEntity.type==2){
                    allPigList.remove(tempEntity.body);
                }
            }
        }
        batch.end();

        //circle login here
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1f);
        shapeRenderer.circle(dragAreaCenter.x, dragAreaCenter.y, dragAreaRadius, 100);
        shapeRenderer.end();
        handleInput(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


    private void createBorder() {
        BodyDef borderBodyDef = new BodyDef();
        FixtureDef borderFixtureDef = new FixtureDef();

        borderBodyDef.type = BodyDef.BodyType.StaticBody;
        borderBodyDef.position.set(new Vector2(0, 0));

        ChainShape borderChainShape = new ChainShape();
        borderChainShape.createLoop(new Vector2[]{new Vector2(0, 1), new Vector2(16, 1), new Vector2(16, 9), new Vector2(0, 9), new Vector2(0, 0)});

        borderFixtureDef.shape = borderChainShape;
        borderFixtureDef.friction = 0.8f;
        borderFixtureDef.restitution = 0f;

        world.createBody(borderBodyDef).createFixture(borderFixtureDef);

        borderChainShape.dispose();
    }

    private void setupInputHandler() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                Vector2 currentCoords = getCoords();
                if(keycode == Input.Keys.E){
                    System.out.println("Inside E");
                    if(findEntity(currentFlyingBird)==null){
                        return true;
                    }
//                    System.out.println("The type of " + findEntity(currentFlyingBird).type2);
                    if(findEntity(currentFlyingBird).type2==1){
                        ((blackBird)findEntity(currentFlyingBird)).useAbility(world, entities);
                    }else if(findEntity(currentFlyingBird).type2==2){
                        ((yellowBird)findEntity(currentFlyingBird)).useAbility(world, entities);
                    }else{
                        System.out.println("Else part no");
                    }
                }else if (keycode == Input.Keys.Y){
                    earthQuake();
                }else if (keycode == Input.Keys.M){
                    GameSaver.saveWorld(entities, "gamesave.bin", allBirdQueue, allPigList);
                }else if(keycode == Input.Keys.N){
                    GameLoader.clearWorld(world);
                    entities.clear();
                    createBorder();
                }else if(keycode == Input.Keys.Q){
                    GameLoader.loadWorld(world, "gamesave.bin", entities, allBirdQueue, allPigList);
                }
                return true;
            }
            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                camera.zoom += amountY / 25f;
                return true;
            }
        });
    }

    private boolean isInsideDragArea(Vector2 touch) {
        return touch.dst(dragAreaCenter) <= dragAreaRadius;
    }
    private entity findEntity(Body body) {
        for(entity entity : entities) {
            if(entity.body.equals(body)){
                return entity;
            }
        }
        return null;
    }
    private void handleInput(float delta) {
        if (Gdx.input.isTouched()) {
//            System.out.println(getCoords().x + "---" + getCoords().y);
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            Vector2 touch = new Vector2(touchPos.x, touchPos.y);
            if (!isDragging && isInsideDragArea(touch)) {
                // Start dragging only if inside the circular area
                dragStart = touch.cpy();
                isDragging = true;
            } else if (isDragging) {
                // Dragging in progress
            }
        } else if (isDragging) {
            // Dragging ended
            isDragging = false;

            Vector3 touchEndPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchEndPos);
            Vector2 touchEnd = new Vector2(touchEndPos.x, touchEndPos.y);

            Vector2 force = dragStart.sub(touchEnd).scl(1);
            force.x = max(min(force.x, 1.5f), -1.5f);
            force.y = max(min(force.y, 1.5f), -1.5f);
//            System.out.println("The x is " + force.x + "The y is " + force.y);
            force.scl(0.75f);
            if(currentActiveBird != null) {
                birdSetTime = 0f;
                temp = false;
//                currentActiveBird.setTransform(2f, 2f, 0);
//                launchBird(force);
                catapult.shoot(force, 10, currentActiveBird);
                currentFlyingBird = currentActiveBird;
                allBirdQueue.poll();
                if(allBirdQueue.peek()!=null) {
                    flag = true;
                }
                temp = true;
            }
        }
    }


    private void setupContactListner(){
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                for(entity entity : entities){
                    if(contact.getFixtureA().getBody() == entity.body || contact.getFixtureB().getBody() == entity.body){
                        Body otherBody = contact.getFixtureA().getBody() == entity.body ? contact.getFixtureB().getBody() : contact.getFixtureA().getBody();

                        Vector2 relVel = otherBody.getLinearVelocity().sub(entity.body.getLinearVelocity());

                        float mass = entity.body.getMass();
                        float momentum = mass * relVel.len();

                        float damage = Math.abs(momentum * 30f);
                        float lv = otherBody.getLinearVelocity().sub(entity.body.getLinearVelocity()).len();
//                        System.out.println("The lv is " + lv);
                        entity.health -= damage * lv;

//                        System.out.println("Block health: " + entity.health + " | Damage dealt: " + damage);
                        break;

                    }
                }
            }

            @Override
            public void endContact(Contact contact) {
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }

        });
    }
    private Vector2 getCoords(){
        Vector3 screenCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        Vector3 worldCoords = camera.unproject(screenCoords);

        float mouseX = worldCoords.x;
        float mouseY = worldCoords.y;
        return new Vector2(mouseX, mouseY);
    }

    private void earthQuake() {
        System.out.println("Earthquake");
        for (entity i : entities) {
            System.out.println("hi");
            if (i.type == 1) {
//                i.body.applyAngularImpulse(0.01f, true);
                i.body.setLinearVelocity(2, 0);
            }
        }
    }
}

