package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class RedBird extends birds
{
    // bird texture
    private Texture RedBird;

    public RedBird(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // bird specific functions
    public void launchBird(){}
    public void UseAbility(){}

    @Override
    public void attack(){}
}
