package it.unibo.oop18.cfc.Objects.Entity;

import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.Objects.AbstractGameObject;

import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;

/**
 * This class is an abstract implementation of {@link DynamicObject}.
 * It defines a generic dynamic game entity.
 */
public abstract class AbstractEntity extends AbstractGameObject implements DynamicObject {

    private final World world;

    /**
     * Creates an {@code AbstractEntity}.
     * 
     * @param position initial entity
     * @param world reference 
     */
    public AbstractEntity(final Position position, final World world) {
    	super(position);
        this.world = world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public World getWorld() {
        return this.world;
    }
}
