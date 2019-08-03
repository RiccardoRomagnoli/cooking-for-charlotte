// Blueprint for all GameState subclasses.
// Has a reference to the GameStateManager
// along with the four methods that must
// be overridden.

package it.unibo.oop18.cfc.GameState;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Manager.GameStateManager;

/**
 * This class provide the basic mechanism to change between different state.
 *
 */
public abstract class GameState {

    protected GameStateManager gsm;
    private final GameStates gameStateName;

    public GameState(GameStateManager gsm, GameStates gameStateName) {
        this.gsm = gsm;
        this.gameStateName = gameStateName;
    }

    public GameStates getGameStateName() {
        return gameStateName;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw(Graphics2D g);

}
