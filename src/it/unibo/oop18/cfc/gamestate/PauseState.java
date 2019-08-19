package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.input.gamestate.PauseStateInput;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Managing the pause screen. Display several info during the pause
 */
public class PauseState extends GameState {

    private static final int POSITION_X_RESUME = 400;
    private static final int POSITION_Y_RESUME = 370;
    private static final int POSITION_X_RESTART = 440;
    private static final int POSITION_Y_RESTART = 430;
    private static final int POSITION_X_MENU = 380;
    private static final int POSITION_Y_MENU = 490;

    /**
     * Class constructor.
     * 
     * @param gsm The {@link GameStateManager}
     */
    public PauseState(final GameStateManager gsm) {
        super(gsm, GameStates.PAUSE);
        super.setInput(new PauseStateInput(this));
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
        if (JukeBoxUtil.isPlaying("themeSong")) {
            JukeBoxUtil.stop("themeSong");
        }
        ContentUtil.drawPause(g);
        ContentUtil.drawStringFont(g, POSITION_X_RESUME, POSITION_Y_RESUME, "Resume: Esc / P");
        ContentUtil.drawStringFont(g, POSITION_X_RESTART, POSITION_Y_RESTART, "Restart: R");
        ContentUtil.drawStringFont(g, POSITION_X_MENU, POSITION_Y_MENU, "Return to menu: F1");
    }
}
