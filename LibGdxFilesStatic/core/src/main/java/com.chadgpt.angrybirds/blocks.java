package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

abstract class blocks extends Entity
{
    // block properties
    private boolean isDestroyed;

    public blocks(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // block fucntions
    public void getDamage(Object obj){}

}
