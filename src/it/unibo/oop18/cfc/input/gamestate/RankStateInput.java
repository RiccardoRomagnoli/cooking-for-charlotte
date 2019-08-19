package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.gamestate.RankState;

/**
 * Rank State Input Class.
 *
 */
public class RankStateInput implements GameStateInput {

    private final RankState rankState;

    /**
     * Create a Game State Input.
     * 
     * @param rankState related state
     */
    public RankStateInput(final GameState rankState) {
        this.rankState = (RankState) rankState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        e.consume();
        this.rankState.getGsm().setState(GameStates.MENU);
    }

    /**
     * {@inheritDoc}
     */
    public void processInputReleased(final KeyEvent e) {
    }
}
