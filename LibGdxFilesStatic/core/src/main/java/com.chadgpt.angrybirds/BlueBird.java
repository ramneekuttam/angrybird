package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class BLueBird extends birds
{
    // bird texture
    private Texture BLueBird;

    public BLueBird(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // bird specific functions
    public void launchBird(){}
    public void UseAbility(){}

    @Override
    public void attack(){}
}
