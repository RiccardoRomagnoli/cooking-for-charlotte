package it.unibo.oop18.cfc.manager;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.gamestate.GameOverState;
import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.InfoState;
import it.unibo.oop18.cfc.gamestate.IntroState;
import it.unibo.oop18.cfc.gamestate.MenuState;
import it.unibo.oop18.cfc.gamestate.OptionState;
import it.unibo.oop18.cfc.gamestate.PauseState;
import it.unibo.oop18.cfc.gamestate.PlayState;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Game manager, help to choose from different state during the game.
 */
public class GameStateManager {

    /** All game state. */
    private final GameState introState;
    private final GameState menuState;
    private final GameState playState;
    private final GameState gameOverState;
    private final GameState pauseState;
    private final GameState infoState;
    private final GameState optionState;

    /** The current state. */
    private GameState currentState;

    /**
     * The GameStateManager does exactly what its
     * name says. It contains a list of GameStates.
     * It decides which GameState to update() and
     * draw() and handles switching between different
     * GameStates.
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
        currentState = introState;
        introState.init();
    }

    /**
     * Start a new game setting the game state.
     */
    public void newGame() {
        playState.init();
        setState(GameStates.PLAY);
    }

    /**
     * Change the current state and initialize it.
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
     * Update the game.
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
