package it.unibo.oop18.cfc.physics;

import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.util.Velocity;

/**
 * The Interface DynamicPhysicsComponent.
 */
public interface DynamicPhysicsComponent {

    /**
     * Gets the dynamic object's velocity.
     *
     * @return the dynamic object {@link VelocityImpl}.
     */
    Velocity getVelocity();

    /**
     * Gets the next position.
     *
     * @return the next {@link Position}
     */
    Position getNextPosition();

    /**
     * Let the entity move.
     */

    void move();

}
