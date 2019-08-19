package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;


/**
 * Interface of Game State Input.
 *
 */
public interface GameStateInput {


    /**
     * Process the pressing of a key in the current state.
     * @param e key pressed event
     */
    void processInputPressed(KeyEvent e);

    /**
     * Process the releasing of a key in the current state.
     * @param e key pressed event
     */
    void processInputReleased(KeyEvent e);
}
