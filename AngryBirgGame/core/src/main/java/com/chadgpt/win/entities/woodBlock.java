package com.chadgpt.win.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

public class woodBlock extends entity {
    public static Texture woodTexture1 = new Texture("wood1.png");
    public static Texture woodTexture2 = new Texture("wood2.png");
    public static Texture woodTexture3 = new Texture("wood3.png");
    public static Texture woodTexture4 = new Texture("wood4.png");

    public static int initialHealth = 10;
    public woodBlock(Body body, float width, float height, int type, int type3) {
        super(body, null, initialHealth, 1, type3);
        Sprite tempSprite = null;
        if(type==1){
            tempSprite= new Sprite(woodTexture1);
        }else if(type==2){
            tempSprite= new Sprite(woodTexture2);
        }else if(type==3){
            tempSprite= new Sprite(woodTexture3);
        }else if (type==4){
            tempSprite= new Sprite(woodTexture4);
        }
        tempSprite.setSize(width * 2.2f, height * 2.2f);
        tempSprite.setOriginCenter();
        this.sprite = tempSprite;
    }
}
