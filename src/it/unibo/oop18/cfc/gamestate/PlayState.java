package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.hud.DownHud;
import it.unibo.oop18.cfc.hud.TopHud;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * The Class PlayState.
 */
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        JukeBoxUtil.load("/SFX/themeSong.wav", "themeSong");
        JukeBoxUtil.load("/SFX/cuttingSound.wav", "cuttingSound");
        JukeBoxUtil.load("/SFX/trashed.wav", "trash.wav");
    }

    /**
     * {@inheritDoc}
     */
    public void update() {
        world.update();
        if (this.world.getPlayer().getLifes() == 0) {
            getGsm().setState(GameStates.GAMEOVER);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        if (JukeBoxUtil.isPlaying("themeSong")) {
            JukeBoxUtil.loop("themeSong");
        } else {
            JukeBoxUtil.resume("themeSong");
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
