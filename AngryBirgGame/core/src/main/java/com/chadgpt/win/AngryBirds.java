package com.chadgpt.win;

import com.badlogic.gdx.Game;
import com.chadgpt.win.screens.GameScreen;
import com.chadgpt.win.screens.OpeningScreen;
import com.chadgpt.win.database.database;
import com.chadgpt.win.screens.SaveGameLoad;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class AngryBirds extends Game {
    public static AngryBirds gameInstance;
    @Override
    public void create() {
        setScreen(new OpeningScreen(this));
//        setScreen(new GameScreen());
//        setScreen(new SaveGameLoad());
        database.game = this;
        gameInstance = this;
    }

    public static AngryBirds getGameInsance(){
        if(gameInstance == null){
            gameInstance = new AngryBirds();
        }
        return gameInstance;
    }

}
