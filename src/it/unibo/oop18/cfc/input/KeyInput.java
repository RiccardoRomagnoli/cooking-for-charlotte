package it.unibo.oop18.cfc.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import it.unibo.oop18.cfc.manager.GameStateManager;

/**
 * KeyInput that implements {@link KeyListener} to manage the running state
 * input.
 */
public class KeyInput implements KeyListener {

    private final GameStateManager gsm;

    /**
     * Creates {@code KeyInput}.
     * 
     * @param gsm state manager used to set state Pause
     */
    public KeyInput(final GameStateManager gsm) {
        this.gsm = gsm;
    }

    /**
     * It generates a {@link Direction} when specific key is pressed and call
     * specific method on specific Game State.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        gsm.getCurrentGameState().getGameStateInput().processInputPressed(e);
    }

    /**
     * It stops the player when a key button is released. If more than one key is
     * pressed, on release the player continues to move to the current key being
     * pressed
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        gsm.getCurrentGameState().getGameStateInput().processInputReleased(e);
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }
}
