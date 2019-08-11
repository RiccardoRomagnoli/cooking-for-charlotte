package it.unibo.oop18.cfc.gamestate;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.manager.GameStateManager;

/**
 * This class provide the basic functions for all different state.
 */
public abstract class GameState {

    /**
     * Game state instance.
     */
    protected GameStateManager gsm;

    /** The game state name. */
    private final GameStates gameStateName;

    /**
     * Constructor for all game states.
     * 
     * @param gsm           game state instance
     * @param gameStateName game state name
     */
    public GameState(final GameStateManager gsm, final GameStates gameStateName) {
        this.gsm = gsm;
        this.gameStateName = gameStateName;
    }

    /**
     * Getter name of game state.
     * 
     * @return game state name
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
     * Draw the scene of the game state.
     * 
     * @param g graphics to be printed on screen
     */
    public abstract void draw(Graphics2D g);

}
