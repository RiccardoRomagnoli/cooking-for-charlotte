package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.util.ContentUtil;

/**
 * Infostate class.
 */
public class InfoState extends GameState {

    private int infoOption;

    /**
     * Class constructor.
     * 
     * @param gsm game state
     */
    public InfoState(final GameStateManager gsm) {
        super(gsm, GameStates.INFO);
    }

    /**
     * {@inheritDoc}.
     */
    public void init() {
        infoOption = 0;
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
        if (infoOption == 0) {
            ContentUtil.drawControlli(g);
        } else {
            ContentUtil.drawGuida(g);
        }
    }

    /**
     * Switch to left image.
     */
    public void goLeft() {
        infoOption = 0;
    }

    /**
     * Switch to right image.
     */
    public void goRight() {
        infoOption = 1;
    }
}
