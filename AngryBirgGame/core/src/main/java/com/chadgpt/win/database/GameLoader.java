package com.chadgpt.win.database;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.chadgpt.win.entities.entity;
import com.chadgpt.win.entities.entityCreator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.abs;

public class GameLoader {

    public static void loadWorld(World world, String fileName, ArrayList<entity> entities, Queue<Body> allbirdlist, ArrayList<Body> piglist) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Read the list of BodyState objects
            List<BodyState> bodyStates = (List<BodyState>) ois.readObject();

            if (bodyStates == null || bodyStates.isEmpty()) {
                System.out.println("Deserialized bodyStates is null or empty.");
                return;
            }

            System.out.println("Deserialized " + bodyStates.size() + " BodyState objects.");

            int count = 0;
            entity tempEntity = null;
            for (BodyState state : bodyStates) {
                database.currentLevel = state.getCurrentLevel();
                    System.out.println("Loading EntityType: " + state.getEntityType());
                System.out.println("Position: (" + state.getX() + ", " + state.getY() + ")");
                System.out.println("Velocity: (" + state.getVx() + ", " + state.getVy() + ")");

                //for birds
                if(state.getEntityType()==0 || state.getEntityType()==99){
                    tempEntity = entityCreator.createBlackBird(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    if(state.getEntityType()==0){
                        allbirdlist.add(tempEntity.body);
                    }
                }else if(abs(state.getEntityType())==1){
                    tempEntity = entityCreator.createBlueBird(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    if(state.getEntityType()==1){
                        allbirdlist.add(tempEntity.body);
                    }
                }else if(abs(state.getEntityType())==2){
                    tempEntity = entityCreator.createRedBird(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    if(state.getEntityType()==2){
                        allbirdlist.add(tempEntity.body);
                    }
                }else if(abs(state.getEntityType())==3){
                    tempEntity = entityCreator.createYellowBird(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    if(state.getEntityType()==3){
                        allbirdlist.add(tempEntity.body);
                    }
                }else if(state.getEntityType()==4){
                    //here onwards pig
                    tempEntity = entityCreator.createJuniorPig(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    piglist.add(tempEntity.body);
                }else if (state.getEntityType()==5){
                    tempEntity = entityCreator.createCorporalPig(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    piglist.add(tempEntity.body);
                }else if(state.getEntityType()==6){
                    tempEntity = entityCreator.createKingPig(state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                    piglist.add(tempEntity.body);
                }else if(state.getEntityType()==7){
                    //wood
                    tempEntity = entityCreator.createWoodBlock(0, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==8){
                    tempEntity = entityCreator.createWoodBlock(1, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==9){
                    tempEntity = entityCreator.createWoodBlock(2, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==10){
                    tempEntity = entityCreator.createWoodBlock(3, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==11){
                    //stone
                    tempEntity = entityCreator.createStoneBlock(0, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==12){
                    tempEntity = entityCreator.createStoneBlock(1, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==13){
                    tempEntity = entityCreator.createStoneBlock(2, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==14){
                    tempEntity = entityCreator.createStoneBlock(3, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==15){
                    //ice
                    tempEntity = entityCreator.createIceBlock(0, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==16){
                    tempEntity = entityCreator.createIceBlock(1, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==17){
                    tempEntity = entityCreator.createIceBlock(2, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }else if(state.getEntityType()==18){
                    tempEntity = entityCreator.createIceBlock(3, state.getX(), state.getY(), world);
                    tempEntity.health = state.getHealth();
                    entities.add(tempEntity);
                }
                if(tempEntity!=null) {
                    tempEntity.body.setTransform(state.getX(), state.getY(), state.getAngle());
                    tempEntity.body.setLinearVelocity(state.getVx(), state.getVy());
                    tempEntity.body.setAngularVelocity(state.getAngularVelocity());
                    count++;
                }
            }
            System.out.println("Total bodies loaded: " + count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (EOFException e) {
            System.out.println("File is empty or corrupted.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void loadWorlddebug(World world, String fileName, ArrayList<entity> entities, Queue<Body> allbirdlist, ArrayList<Body> piglist) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<BodyState> bodyStates = (List<BodyState>) ois.readObject();

            if (bodyStates == null || bodyStates.isEmpty()) {
                System.out.println("Deserialized bodyStates is null or empty.");
                return;
            }

            System.out.println("Loaded " + bodyStates.size() + " BodyState objects.");
            for (BodyState state : bodyStates) {
                System.out.println("Loaded EntityType: " + state.getEntityType());
            }
        } catch (InvalidClassException e) {
            System.out.println("Class version mismatch: " + e.getMessage());
        } catch (StreamCorruptedException e) {
            System.out.println("Stream is corrupted: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void clearWorld(World world) {
        // Destroy all bodies in the world
        Array<Body> bodies = new Array<>();
        world.getBodies(bodies);
        for (Body body : bodies) {
            world.destroyBody(body);
        }
    }
}
