package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.util.JukeBoxUtil;
import it.unibo.oop18.cfc.gamestate.GameOverState;


/**
 * Game Over State Input Class.
 *
 */
public class GameOverStateInput implements GameStateInput {

    private final GameOverState gameOverState;

    /**
     * Create a Game State Input.
     * @param gameOverState related state
     */
    public GameOverStateInput(final GameState gameOverState) {
        this.gameOverState = (GameOverState) gameOverState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            gameOverState.goUp();
            break;
        case KeyEvent.VK_DOWN:
            gameOverState.goDown();
            break;
        case KeyEvent.VK_LEFT:
            gameOverState.goLeft();
            break;
        case KeyEvent.VK_RIGHT:
            gameOverState.goRight();
            break;
        case KeyEvent.VK_ENTER:
            JukeBoxUtil.play("collect");
            gameOverState.save();
            gameOverState.getGsm().setState(GameStates.MENU);
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
    }

}
