package com.chadgpt.win.entities;

import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

//this is for strategy pattern these methods are implemented when we want to have bird ability

public interface ability {
    public void useAbility(World world, ArrayList<entity> entities);
}
