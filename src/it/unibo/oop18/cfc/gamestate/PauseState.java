package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Managing the pause screen. Display several info during the pause
 */
public class PauseState extends GameState {

    /**
     * Class constructor.
     * 
     * @param gsm gamestate
     */
    public PauseState(final GameStateManager gsm) {
        super(gsm, GameStates.PAUSE);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {

    }

    /**
     * {@inheritDoc}.
     */
    public void update() {
    }

    /**
     * {@inheritDoc}.
     * 
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {
        if (PlayState.themeIsPlaying == 1) {
            JukeBoxUtil.stop("themeSong");
            PlayState.themeIsPlaying = 2;
        }

        ContentUtil.drawString(g, "pause", 400, 200);

        ContentUtil.drawString(g, "arrow keys : move", 120, 270);

        ContentUtil.drawString(g, "space : action", 200, 340);

        ContentUtil.drawString(g, "F1: return to menu", 120, 410);
    }
}
