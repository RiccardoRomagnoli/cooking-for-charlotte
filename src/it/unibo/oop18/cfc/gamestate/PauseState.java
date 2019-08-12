package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Managing the pause screen. Display several info during the pause
 */
public class PauseState extends GameState {

    private static final int POSITION_X_PAUSE = 400;
    private static final int POSITION_Y_PAUSE = 200;
    private static final int POSITION_X_MOVE = 120;
    private static final int POSITION_Y_MOVE = 270;
    private static final int POSITION_X_DOACTION = 200;
    private static final int POSITION_Y_DOACTION = 340;
    private static final int POSITION_X_MENU = 120;
    private static final int POSITION_Y_MENU = 410;

    /**
     * Class constructor.
     * 
     * @param gsm The {@link GameStateManager}
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
     */
    public void draw(final Graphics2D g) {
        if (PlayState.themeIsPlaying == 1) {
            JukeBoxUtil.stop("themeSong");
            PlayState.themeIsPlaying = 2;
        }

        ContentUtil.drawString(g, "pause", POSITION_X_PAUSE, POSITION_Y_PAUSE);

        ContentUtil.drawString(g, "arrow keys : move", POSITION_X_MOVE, POSITION_Y_MOVE);

        ContentUtil.drawString(g, "space : action", POSITION_X_DOACTION, POSITION_Y_DOACTION);

        ContentUtil.drawString(g, "F1: return to menu", POSITION_X_MENU, POSITION_Y_MENU);
    }
}
