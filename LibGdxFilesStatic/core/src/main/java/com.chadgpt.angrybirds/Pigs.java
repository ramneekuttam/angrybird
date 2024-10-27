package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

abstract class Pigs extends Entity
{
    // pig properties
    int weight;

    public Pigs(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // pig functions
    public void getDamage(){}
}
