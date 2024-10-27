package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

abstract class birds extends Entity
{
    // bird properties
    private int damage;
    private int speed;
    private boolean is_launched;
    private boolean is_abilityUsed;

    public birds(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // bird functions
    public void attack(){}

}
