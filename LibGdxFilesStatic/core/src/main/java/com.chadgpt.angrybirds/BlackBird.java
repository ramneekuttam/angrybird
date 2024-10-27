package com.chadgpt.angrybirds;

import com.badlogic.gdx.graphics.Texture;

class BlackBird extends birds
{
    // bird texture
    private Texture BlackBird;

    public BlackBird(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    // bird specific functions
    public void launchBird(){}
    public void UseAbility(){}

    @Override
    public void attack(){}
}
