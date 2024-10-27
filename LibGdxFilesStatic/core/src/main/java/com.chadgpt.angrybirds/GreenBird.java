package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class GreenBird extends birds
{
    // bird texture
    private Texture GreenBird;

    public GreenBird(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // bird specific functions
    public void launchBird(){}
    public void UseAbility(){}

    @Override
    public void attack(){}
}
