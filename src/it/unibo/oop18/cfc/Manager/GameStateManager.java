// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package it.unibo.oop18.cfc.Manager;

import java.awt.Graphics2D;
import it.unibo.oop18.cfc.GameState.*;
import it.unibo.oop18.cfc.Util.JukeBoxUtil;

/**
 * Game manager, help to choose from different state during the game.
 */
public class GameStateManager {
    private final GameState introState;
    private final GameState menuState;
    private final GameState playState;
    private final GameState gameOverState;
    private final GameState pauseState;
    private final GameState infoState;
    private final GameState optionState;

    private GameState currentState;

    /**
     * TODO. add intro case
     */
    public GameStateManager() {
        JukeBoxUtil.init();
        pauseState = new PauseState(this);
        introState = new IntroState(this);
        menuState = new MenuState(this);
        gameOverState = new GameOverState(this);
        playState = new PlayState(this);
        infoState = new InfoState(this);
        optionState = new OptionState(this);
        setState(GameStates.INTRO);
    }

    /**
     * Start a new game setting the game state.
     */
    public void newGame() {
        playState.init();
        setState(GameStates.PLAY);
    }

    /**
     * TODO. remove intro case and add the code in the constructor
     * 
     * @param gameState current game state
     */
    public void setState(final GameStates gameState) {
        switch (gameState) {
        case INTRO:
            currentState = introState;
            introState.init();
            break;
        case MENU:
            currentState = menuState;
            menuState.init();
            break;
        case PLAY:
            currentState = playState;
            break;
        case GAMEOVER:
            currentState = gameOverState;
            gameOverState.init();
            break;
        case PAUSE:
            currentState = pauseState;
            break;
        case INFO:
            currentState = infoState;
            infoState.init();
            break;
        case OPTION:
            currentState = optionState;
            optionState.init();
        default:
            break;
        }
    }

    /**
     * Update the graphics.
     */
    public void update() {
        currentState.update();
    }

    /**
     * Draw the graphics on the panel.
     * 
     * @param g graphics
     */
    public void draw(final Graphics2D g) {
        currentState.draw(g);
    }

    /**
     * Getter for playstate.
     * 
     * @return current playstate
     */
    public PlayState getPlayState() {
        return (PlayState) playState;
    }

    /**
     * Getter for current game state.
     * 
     * @return current state
     */
    public GameState getCurrentGameState() {
        return currentState;
    }
}
