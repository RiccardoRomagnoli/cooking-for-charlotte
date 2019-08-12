package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;
import it.unibo.oop18.cfc.manager.GameStateManager;

/**
 * This class provide the basic functions for all different state.
 */
public abstract class GameState {

    /**
     * Game state manager instance.
     */
    private GameStateManager gsm;

    /** The game state name. */
    private final GameStates gameStateName;

    /**
     * Constructor for all game states.
     * 
     * @param gsm           the {@link GameStateManager}
     * @param gameStateName the game state name
     */
    public GameState(final GameStateManager gsm, final GameStates gameStateName) {
        this.gsm = gsm;
        this.gameStateName = gameStateName;
    }

    /**
     * @return the {@link GameStateManager}
     */
    public GameStateManager getGsm() {
        return gsm;
    }

    /**
     * @param gsm the {@link GameStateManager} to set
     */
    public void setGsm(final GameStateManager gsm) {
        this.gsm = gsm;
    }

    /**
     * Getter name of game state.
     * 
     * @return {@link GameStates} name
     */
    public GameStates getGameStateName() {
        return gameStateName;
    }

    /**
     * Initialize the game state components.
     */
    public abstract void init();

    /**
     * Update the game state component.
     */
    public abstract void update();

    /**
     * Draw the scene of the game state on screen.
     * 
     * @param g {@link Graphics2D} of the game
     */
    public abstract void draw(Graphics2D g);

}
