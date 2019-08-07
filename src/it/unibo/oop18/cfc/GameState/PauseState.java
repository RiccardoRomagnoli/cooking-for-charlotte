// The pause GameState can only be activated
// by calling GameStateManager#setPaused(true).

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;
import it.unibo.oop18.cfc.Manager.Content;
import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * Managing the pause screen. Display several info during the pause
 */
public class PauseState extends GameState {

    /**
     * Class constructor.
     * @param gsm gamestate
     */
    public PauseState(final GameStateManager gsm) {
        super(gsm, GameStates.PAUSE);
    }

    /**
     * Init class.
     */
    public void init() {
    }

    /**
     * Update class. Nothing has to be done until it is on pause
     */
    public void update() {
    }

    /**
     * Draw elements on the pause screen.
     * 
     * @param g basic graphics
     */
    public void draw(final Graphics2D g) {

        Content.drawString(g, "pause", 400, 200);

        Content.drawString(g, "arrow keys : move", 120, 270);

        Content.drawString(g, "space : action", 200, 340);

        Content.drawString(g, "F1: return to menu", 120, 410);
    }
}
