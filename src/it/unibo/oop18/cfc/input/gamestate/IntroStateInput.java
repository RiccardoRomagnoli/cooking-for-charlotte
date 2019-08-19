package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.IntroState;
import it.unibo.oop18.cfc.util.JukeBoxUtil;

/**
 * Intro State Input Class.
 *
 */
public class IntroStateInput implements GameStateInput {

    private final IntroState introState;

    /**
     * Create a Game State Input.
     * 
     * @param introState related state
     */
    public IntroStateInput(final GameState introState) {
        this.introState = (IntroState) introState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            introState.getGsm().setState(GameStates.MENU);
            JukeBoxUtil.play("collect");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
    }

}
