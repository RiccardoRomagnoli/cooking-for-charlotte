package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.PauseState;

/**
 * Pause state Input class.
 *
 */
public class PauseStateInput implements GameStateInput {

    private final PauseState pauseState;

    /**
     * Create a Game State Input.
     * 
     * @param pauseState related state
     */
    public PauseStateInput(final GameState pauseState) {
        this.pauseState = (PauseState) pauseState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_ESCAPE:
        case KeyEvent.VK_P:
            pauseState.getGsm().resumePlayState();
            break;
        case KeyEvent.VK_R:
            pauseState.getGsm().getPlayState().getWorld().stopTimers();
            pauseState.getGsm().newGame();
            break;
        case KeyEvent.VK_F1:
            pauseState.getGsm().getPlayState().getWorld().stopTimers();
            pauseState.getGsm().setState(GameStates.MENU);
            break;
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
