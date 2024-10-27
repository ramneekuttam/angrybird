package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class stone extends blocks
{
    // block texture
    private Texture stone;

    public stone(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // block method
    public void impact(Object obj){}
}
