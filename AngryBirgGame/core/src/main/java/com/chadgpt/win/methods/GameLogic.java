package com.chadgpt.win.methods;

import com.badlogic.gdx.physics.box2d.Body;

import java.util.ArrayList;
import java.util.Queue;

public class GameLogic {
    public static boolean checkWinCondition(ArrayList<Body> allPigList){
        if(allPigList.isEmpty()){
            return true;
        }
        return false;
    }
}
