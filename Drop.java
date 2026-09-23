package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Entry point of the game. Holds the objects shared between screens
 * (SpriteBatch, BitmapFont, Viewport) and sets the first Screen.
 *
 * Based on the LibGDX "Extending the Simple Game" tutorial:
 * https://libgdx.com/wiki/start/simple-game-extended
 */
public class Drop extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        // use libGDX's default font
        font = new BitmapFont();
        viewport = new FitViewport(8, 5);

        // font has 15pt, but we need to scale it to our viewport
        // by ratio of viewport height to screen height
        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render(); // important! delegates render to the active Screen
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        // dispose the currently active screen as well, so its own
        // resources (textures/sounds/music) are freed on exit
        if (getScreen() != null) {
            getScreen().dispose();
        }
    }
}
