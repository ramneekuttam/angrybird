package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class tntblock extends blocks
{
    // block texture
    private Texture TNT_block;

    public tntblock(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // block method
    public void impact(Object obj){}
    public void blast(){}
}
