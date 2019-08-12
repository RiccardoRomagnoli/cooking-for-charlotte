package it.unibo.oop18.cfc.object.entity;

import it.unibo.oop18.cfc.object.AbstractGameObject;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;

/**
 * This class is an abstract implementation of {@link DynamicObject}. It defines
 * a generic dynamic game entity.
 */
public abstract class AbstractEntity extends AbstractGameObject implements DynamicObject {

    private final World world;

    /**
     * Creates an {@link AbstractEntity}.
     * 
     * @param position initial entity
     * @param world    reference
     */
    public AbstractEntity(final Position position, final World world) {
        super(position);
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    public World getWorld() {
        return this.world;
    }
}
