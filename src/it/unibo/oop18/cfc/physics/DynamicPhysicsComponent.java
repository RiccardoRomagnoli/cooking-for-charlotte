package it.unibo.oop18.cfc.physics;

import java.awt.geom.Rectangle2D;
import java.util.Set;

import it.unibo.oop18.cfc.object.items.Item;
import it.unibo.oop18.cfc.tilemap.TileType;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.util.Velocity;

public interface DynamicPhysicsComponent {

    void move();

    /**
     * Gets the dynamic object's velocity.
     *
     * @return the dynamic object {@link VelocityImpl}.
     */
    Velocity getVelocity();

    /**
     * Gets an entity upper shape.
     *
     * @return a rectangle to check a upper bound collision
     */
    Rectangle2D getTopBound();

    /**
     * Gets an entity lower shape.
     *
     * @return a rectangle to check a lower bound collision
     */
    Rectangle2D getLowerBound();

    /**
     * Gets an entity left shape.
     *
     * @return a rectangle to check a left bound collision
     */
    Rectangle2D getLeftBound();

    /**
     * Gets an entity right shape.
     *
     * @return a rectangle to check a right bound collision
     */
    Rectangle2D getRightBound();

    /**
     * {@inheritDoc}
     */
    public abstract void checksCollisions(Set<Item> object);

   // public TileType getNextTile();

}
