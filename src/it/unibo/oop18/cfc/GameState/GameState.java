// Blueprint for all GameState subclasses.
// Has a reference to the GameStateManager
// along with the four methods that must
// be overridden.

package it.unibo.oop18.cfc.GameState;

import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;

import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * This class provide the basic mechanism to change between different state.
 */
public abstract class GameState {

    /**
     * Gamestate istance.
     */
    protected GameStateManager gsm;
    private final GameStates gameStateName;

    /**
     * Constructor for gamestate manager.
     * 
     * @param gsm gamestate istance
     * @param gameStateName gamestate name
     */
    public GameState(final GameStateManager gsm, final GameStates gameStateName) {
        this.gsm = gsm;
        this.gameStateName = gameStateName;
    }

    /**
     * Getter state of running gamestate.
     * 
     * @return gamestate running
     */
    public GameStates getGameStateName() {
        return gameStateName;
    }

    /**
     * Initialize the gamestate.
     */
    public abstract void init();

    /**
     * Update the gamestate.
     */
    public abstract void update();

    /**
     * Draw the scene of the gamestate. It loops until the scene is on the screen.
     * @param g graphics to be printed on screen
     */
    public abstract void draw(Graphics2D g);

}
