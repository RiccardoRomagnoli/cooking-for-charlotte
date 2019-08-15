package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import java.io.IOException;
import it.unibo.oop18.cfc.hud.DownHud;
import it.unibo.oop18.cfc.hud.TopHud;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.util.SoundUtil;
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
        JukeBoxUtil.load(SoundUtil.THEME_PATH, SoundUtil.THEME_SOUND);
        JukeBoxUtil.load(SoundUtil.CUTTING_PATH, SoundUtil.CUTTING_SOUND);
        JukeBoxUtil.load(SoundUtil.TRASH_PATH, SoundUtil.TRASH_SOUND);
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
        if (!JukeBoxUtil.isPlaying(SoundUtil.THEME_SOUND)) {
            JukeBoxUtil.loop(SoundUtil.THEME_SOUND);
        } else {
            JukeBoxUtil.resume(SoundUtil.THEME_SOUND);
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
