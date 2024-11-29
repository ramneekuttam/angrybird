package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class iceBlock extends entity {
    public static Texture iceTexture1 = new Texture("ice1.png");
    public static Texture iceTextur2 = new Texture("ice2.png");
    public static Texture iceTexture3 = new Texture("ice3.png");
    public static Texture iceTexture4 = new Texture("ice4.png");

    public static int initialHealth = 25;
    public iceBlock(Body body, float width, float height, int type, int type3) {
        super(body, null, initialHealth, 1, type3);
        Sprite tempSprite = null;
        if(type==1){
            tempSprite= new Sprite(iceTexture1);
        }else if(type==2){
            tempSprite= new Sprite(iceTextur2);
        }else if(type==3){
            tempSprite= new Sprite(iceTexture3);
        }else if (type==4){
            tempSprite= new Sprite(iceTexture4);
        }
        tempSprite.setSize(width * 2.2f, height * 2.2f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
