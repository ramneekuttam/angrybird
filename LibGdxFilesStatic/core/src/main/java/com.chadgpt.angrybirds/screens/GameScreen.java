package com.chadgpt.angrybirds.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.chadgpt.angrybirds.AngryBirds;

import java.util.ArrayList;

public class GameScreen implements Screen {
    AngryBirds game;
    private Stage stage;
    private final Texture background;
    private final Texture catapult;
    private final Texture powerbutton;
    private final Texture bird1;
    private final Texture bird2;
    private final Texture bird3;
    private final Texture ice;
    private final Texture stone;
    private final Texture wood;
    private final Texture tnt;
    private final Texture pig1;
    private final Texture pig2;
    private final Texture pig3;
    private final Texture pausebutton;
    private final Sound sound;
    private final int fac;
    String[] structureMatrix = {
        "0S000000S0",
        "SSS0000SSS",
        "SIS0000SIS",
        "SISWWWWSIS",
        "SISW00WSIS",
        "SISW00WSIS",
        "SISWR0WSIS",
        "SQSWWWWSQS",
        "STSSSSSSTS",
        "SSSSSSSSSS",
    };

    String[] structureMatrix1 = {
        "000SQ000",
        "000II000",
        "000SS000",
        "000WW000",
        "000II000",
        "000SS000",
        "0P0WW0P0",
        "WWWWWWWW",
        "SSSSSSSS"
    };

    String[] structureMatrix2 = {
        "0000SS0000",
        "00SSSSSS00",
        "0SISWWSIS0",
        "SSISWWSISS",
        "SWISP0WIWS",
        "SWISRRWIWS",
        "SWISQQWIWS",
        "SWWWWWWWWS",
        "STTSSSTTTS",
        "SSSSSSSSSS"
    };

    private ArrayList<String[]> lst;
    public GameScreen(AngryBirds game, int fac) {
        this.game = game;
        stage = new Stage(new StretchViewport(1980, 1090));
        background = new Texture("scene3.png");
        catapult = new Texture("ui/catapult.png");
        powerbutton = new Texture("ui/powermenu.png");
        bird1 = new Texture("ui/black.png");
        bird2 = new Texture("ui/green.png");
        bird3 = new Texture("ui/red.png");
        ice = new Texture("ui/glass_1.png");
        stone = new Texture("ui/stone_block_1.png");
        wood = new Texture("ui/wood.png");
        tnt = new Texture("ui/tnt.png");
        pig1 = new Texture("ui/pig.png");
        pig2 = new Texture("ui/pig1.png");
        pig3 = new Texture("ui/pig2.png");
        pausebutton = new Texture("ui/pause.png");
        this.fac = fac;
        lst = new ArrayList<>();
        lst.add(structureMatrix);
        lst.add(structureMatrix1);
        lst.add(structureMatrix2);
        sound = Gdx.audio.newSound(Gdx.files.internal("sounds/bird.mp3"));
        sound.loop();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
        ScreenUtils.clear(0, 0, 0, 0);
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Convert y-coordinate
        if(Gdx.input.justTouched()){
            System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
        }
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 1980, 1080);
        stage.getBatch().draw(catapult, 300, 130, 150, 150);
        stage.getBatch().draw(bird1, 300, 130, 100, 100);
        stage.getBatch().draw(bird2, 250, 130, 100, 100);
        stage.getBatch().draw(bird3, 175, 130, 100, 100);
        drawButton(pausebutton, 100, 900, 100, 100, x, y, () ->{
            this.dispose();
            game.setScreen(new PauseScreen  (game, fac));
        });
        drawButton(powerbutton, 250, 900, 100, 100, x, y, () -> {
            this.dispose();
            game.setScreen(new PowerMenu(game, fac));
        });
        drawStructure(1200, 130, 75, lst.get(fac), 0.91);
        if(Gdx.input.isKeyJustPressed(Input.Keys.X)){
            this.dispose();
            game.setScreen(new WinScreen(game));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Y)){
            this.dispose();
            game.setScreen(new LoseScreen(game));
        }

        stage.getBatch().end();
    }

    private void drawButton(Texture normalTexture,float x, float y, float width, float height, int mouseX, int mouseY, Runnable onClick) {
        // Check if the mouse is over the button
        boolean isHovered = mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

        // Draw the appropriate texture
        if (isHovered) {
            stage.getBatch().draw(normalTexture, x, y, width+50, height+30);
            if (Gdx.input.justTouched()) {
                onClick.run(); // Execute the click action
            }
        } else {
            stage.getBatch().draw(normalTexture, x, y, width, height);
        }
    }
    private void drawStructure(float startX, float startY, float blockSize, String[] structureMatrix, double delta){
        for (int row = structureMatrix.length - 1; row >= 0; row--) {
            String currentRow = structureMatrix[row];
            for (int col = 0; col < currentRow.length(); col++) {
                char blockType = currentRow.charAt(col);
                float x1 = (float) (startX + col * blockSize * delta);
                float y1 = (float) (startY + (structureMatrix.length - 1 - row) * blockSize * delta); // Adjust y to draw upwards
                switch (blockType) {
                    case 'T':
                        stage.getBatch().draw(tnt, x1, y1, blockSize, blockSize);
                        break;
                    case 'P':
                        stage.getBatch().draw(pig1, x1, y1, blockSize, blockSize);
                        break;
                    case 'Q':
                        stage.getBatch().draw(pig2, x1, y1, blockSize, blockSize);
                        break;
                    case 'R':
                        stage.getBatch().draw(pig3, x1, y1, blockSize, blockSize);
                        break;
                    case 'W':
                        stage.getBatch().draw(wood, x1, y1, blockSize, blockSize);
                        break;
                    case 'S':
                        stage.getBatch().draw(stone, x1, y1, blockSize, blockSize);
                        break;
                    case 'I':
                        stage.getBatch().draw(ice, x1, y1, blockSize, blockSize);
                        break;
                    case '0':
                    case '-':
                    default:
                        break;
                }
            }
        }

    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bird1.dispose();
        bird2.dispose();
        bird3.dispose();
        pausebutton.dispose();
        ice.dispose();
        stone.dispose();
        wood.dispose();
        powerbutton.dispose();
        pig1.dispose();
        pig2.dispose();
        pig3.dispose();
        stage.dispose();
        sound.dispose();
    }
}

