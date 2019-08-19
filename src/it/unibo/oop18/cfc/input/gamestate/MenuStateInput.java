package it.unibo.oop18.cfc.input.gamestate;

import java.awt.event.KeyEvent;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.MenuState;

/**
 * Menu State Input Class.
 *
 */
public class MenuStateInput implements GameStateInput {

    private final MenuState menuState;

    /**
     * Create a Game State Input.
     * 
     * @param menuState related state
     */
    public MenuStateInput(final GameState menuState) {
        this.menuState = (MenuState) menuState;
    }

    /**
     * {@inheritDoc}
     */
    public void processInputPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            menuState.goUp();
            break;
        case KeyEvent.VK_DOWN:
            menuState.goDown();
            break;
        case KeyEvent.VK_ENTER:
            menuState.select();
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
