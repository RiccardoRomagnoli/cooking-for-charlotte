package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.OptionState;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Option State Input Class.
 *
 */
public class OptionStateInput implements GameStateInput {

    private final OptionState optionState;

    /**
     * Create a Game State Input.
     * 
     * @param optionState related state
     */
    public OptionStateInput(final GameState optionState) {
        this.optionState = (OptionState) optionState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            optionState.goUp();
            break;
        case KeyEvent.VK_DOWN:
            optionState.goDown();
            break;
        case KeyEvent.VK_RIGHT:
            optionState.increase();
            break;
        case KeyEvent.VK_LEFT:
            optionState.decrease();
            break;
        default:
            break;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            optionState.getGsm().setState(GameStates.MENU);
            JukeBoxUtil.play("collect");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
    }

}
