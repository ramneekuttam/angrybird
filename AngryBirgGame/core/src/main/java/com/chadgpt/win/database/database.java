package com.chadgpt.win.database;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import com.chadgpt.win.AngryBirds;
import com.chadgpt.win.entities.entity;
public class database {
    private static final Texture background1 = new Texture("gamebackground1.png");
    private static Texture background2 = new Texture("gamebackground2.png");
    private static Texture background3 = new Texture("gamebackground3.png");
    public static Texture backbutton = new Texture("ui/back.png");
    public static Texture reloadbutton = new Texture("ui/reload.png");
    public static Texture savebutton = new Texture("ui/save.png");
    public static Sound mainaudio = Gdx.audio.newSound(Gdx.files.internal("sounds/bgm.mp3"));
    public static AngryBirds game = null;
    private static String[] level2 = {
        "123",
        "0q00000q",
        "0k00k",
        "a0pa00a",
        "0c00c",
        "0e0000e",
        "g0000g"
    };
    private static String[] level1 = {
        "123",
        "000000p",
        "00000c",
        "0dp0dp0d",
        "0k00k",
        "a00a00a",
        "a00a00a",
    };

    private static String[] level3 = {
        "412",
        "000r0000e0q",
        "00g0000g",
        "e00e00e00e",
        "00g0000g",
        "a0pa00a0pa",
        "00c0000c",
        "e00e00e00e",
        "00g0000g",
    };

    private static String[] levelsandbox = {
        "1234",
        "a00000a",
        "a00000a",
        "a00p00a"
    };
//    public static
    public static int currentLevel = 0;
    public static Texture getBackground() {
        if(currentLevel == 0) {
            return background1;
        }else if (currentLevel == 1) {
            return background2;
        }else if(currentLevel == 3) {
            return background3;
        }else{
            return background1;
        }
    }
//    public static void setEntities(ArrayList<entity> entities) {
//        database.entities = entities;
//    }
//    public static ArrayList<entity> getEntities() {
//        return database.entities;
//    }
    public static String[] getmatrix() {
        if(currentLevel == 0) {
            return level1;
        } else if (currentLevel == 1) {
            return level2;
        }else if(currentLevel == 2) {
            return level3;
        }else{
            return levelsandbox;
        }
    }
}
