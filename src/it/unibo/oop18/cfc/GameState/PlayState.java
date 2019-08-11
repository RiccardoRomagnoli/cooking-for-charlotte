// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.HUD.DownHud;
import it.unibo.oop18.cfc.HUD.TopHud;
import it.unibo.oop18.cfc.Manager.GameStateManager;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;
import it.unibo.oop18.cfc.World.World;
import it.unibo.oop18.cfc.World.WorldImpl;

public class PlayState extends GameState {

    private World world;
    private TopHud topHud;
    private DownHud downHud;
    /**
     * 0 - not playing (never started) / 1 - playing / 2 - not playing (paused).
     */
    public static int themeIsPlaying;

    /**
     * Constructor.
     * 
     * @param gsm state manager
     */
    public PlayState(final GameStateManager gsm) {
        super(gsm, GameStates.PLAY);
    }

    /**
     * {@inheritDoc}
     */
    public void init() {
        try {
            this.world = new WorldImpl();
            this.topHud = new TopHud(world);
            this.downHud = new DownHud(world);
            this.world.getGameTimer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JukeBoxUtil.load("/SFX/themeSong.wav", "themeSong");
        JukeBoxUtil.load("/SFX/cuttingSound.wav", "cuttingSound");
        JukeBoxUtil.load("/SFX/trashed.wav", "trash.wav");
        MenuState.menuIsPlaying = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void update() {
        world.update();
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        if (themeIsPlaying == 0) {
            JukeBoxUtil.play("themeSong");
            themeIsPlaying = 1;
        } else if (themeIsPlaying == 2) {
            JukeBoxUtil.resume("themeSong");
            themeIsPlaying = 1;
        }
        topHud.draw(g);
        downHud.draw(g);
        world.draw(g);
    }

    /**
     * Return the created world.
     * 
     * @return world
     */
    public World getWorld() {
        return this.world;
    }
}
