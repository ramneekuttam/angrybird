package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class stoneBlock extends entity {
    public static Texture stoneTexture1 = new Texture("stone1.png");
    public static Texture stoneTexture2 = new Texture("stone2.png");
    public static Texture stoneTexture3 = new Texture("stone3.png");
    public static Texture stoneTexture4 = new Texture("stone4.png");
    public static int initialHealth = 50;
    public stoneBlock(Body body, float width, float height, int type, int type3) {
        super(body, null, initialHealth, 1, type3);
        Sprite tempSprite = null;
        if(type==1){
            tempSprite= new Sprite(stoneTexture1);
        }else if(type==2){
            tempSprite= new Sprite(stoneTexture2);
        }else if(type==3){
            tempSprite= new Sprite(stoneTexture3);
        }else if (type==4){
            tempSprite= new Sprite(stoneTexture4);
        }
        tempSprite.setSize(width * 2.2f, height * 2.2f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
