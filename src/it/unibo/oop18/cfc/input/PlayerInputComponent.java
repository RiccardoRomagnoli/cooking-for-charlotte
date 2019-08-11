package it.unibo.oop18.cfc.input;

import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.util.Position;

/**
 * Interface to models the player input and manage its commands in the game.
 */
public interface PlayerInputComponent extends InputComponent {

    /**
     * Moves the player in a specific {@link Direction}.
     *
     * @param way to take in the next movement
     */
    void move(Direction way);

    /**
     * Stops player's movement.
     */
    void stop();

    /**
     * Do action on a specific Station
     */
    void doAction();
}
