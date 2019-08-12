package it.unibo.oop18.cfc.object.floors;

import it.unibo.oop18.cfc.object.AbstractGameObject;
import it.unibo.oop18.cfc.util.Position;

/**
 * This class models a still {@link AbstractGameObject}.
 */
public abstract class AbstractFloorObject extends AbstractGameObject {

    /**
     * Creates an {@link AbstractFloorObject}.
     * 
     * @param position object's position
     */
    public AbstractFloorObject(final Position position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    public Position getPosition() {
        return new Position(super.getPosition());
    }
}
