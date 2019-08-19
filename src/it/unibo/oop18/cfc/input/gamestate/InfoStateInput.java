package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.InfoState;

/**
 * Game State Input Class.
 *
 */
public class InfoStateInput implements GameStateInput {

    private final InfoState infoState;

    /**
     * Create a Game State Input.
     * 
     * @param infoState related state
     */
    public InfoStateInput(final GameState infoState) {
        this.infoState = (InfoState) infoState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            infoState.goLeft();
            break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            infoState.goRight();
            break;
        default:
            infoState.getGsm().setState(GameStates.MENU);
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
    }

}
