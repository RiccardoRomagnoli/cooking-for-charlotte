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
    private GameState introState;
    private GameState menuState;
    private GameState playState;
    private GameState gameOverState;
    private GameState pauseState;
    private GameState infoState;

    private GameState currentState;

    public GameStateManager() {
        JukeBoxUtil.init();
        pauseState = new PauseState(this);
        introState = new IntroState(this);
        menuState = new MenuState(this);
        gameOverState = new GameOverState(this);
        playState = new PlayState(this);
        infoState = new InfoState(this);
        setState(GameStates.INTRO);
    }

    public void newGame() {
        playState.init();
        setState(GameStates.PLAY);
    }

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
        default:
            break;
        }
    }

    public void update() {
        currentState.update();
    }

    public void draw(Graphics2D g) {
        currentState.draw(g);
    }

    public PlayState getPlayState() {
        return (PlayState) playState;
    }

    public GameState getCurrentGameState() {
        return currentState;
    }
}
