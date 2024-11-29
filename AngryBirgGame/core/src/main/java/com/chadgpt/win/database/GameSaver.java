package com.chadgpt.win.database;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.chadgpt.win.entities.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GameSaver {

//    public static void saveWorld(ArrayList<entity> entities, String fileName, Queue<Body> allbirdlist, ArrayList<Body> allpig) {
//        List<BodyState> bodyStates = new ArrayList<>();
//        for (entity e : entities) {
//            int i = e.type3;
//            if(!allbirdlist.contains(e.body)){
//                i = i * -1;
//            }
//            bodyStates.add(new BodyState(e.body.getPosition().x, e.body.getPosition().y, e.body.getAngle(), e.body.getLinearVelocity().x, e.body.getLinearVelocity().y, e.body.getAngularVelocity(), i));
//        }
//        for (BodyState state : bodyStates) {
//            System.out.println("Saved EntityType: " + state.getEntityType());
//            System.out.println("Saved Position: (" + state.getX() + ", " + state.getY() + ")");
//            System.out.println("Saved Velocity: (" + state.getVx() + ", " + state.getVy() + ")");
//        }
//
//        // Serialize the list of body states to a file
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(bodyStates);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
public static void saveWorld(ArrayList<entity> entities, String fileName, Queue<Body> allbirdlist, ArrayList<Body> allpig) {
    List<BodyState> bodyStates = new ArrayList<>();
    for (entity e : entities) {
        int i = e.type3;
        if (!allbirdlist.contains(e.body) && i < 4) {
            i = i * -1;
        }
        if(e.type3==0 && !allbirdlist.contains(e.body)) {
            i = 99;
        }
        bodyStates.add(new BodyState(e.body.getPosition().x, e.body.getPosition().y, e.body.getAngle(),
            e.body.getLinearVelocity().x, e.body.getLinearVelocity().y, e.body.getAngularVelocity(), i, e.health, database.currentLevel));
    }

    System.out.println("Saving " + bodyStates.size() + " BodyState objects.");
    for (BodyState state : bodyStates) {
        System.out.println("Saving EntityType: " + state.getEntityType());
    }

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(bodyStates);
        System.out.println("File saved successfully: " + fileName);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
