package it.unibo.oop18.cfc.Objects.Floors;

import it.unibo.oop18.cfc.Objects.AbstractGameObject;
import it.unibo.oop18.cfc.Util.Position;

/**
 *  This class models a still {@link AbstractGameObject}.
 */
public abstract class AbstractFloorObject extends AbstractGameObject {

    /**
     * Creates an {@code AbstractFloorObject}.
     * 
     * @param position object's position
     */
    public AbstractFloorObject(final Position position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Position getPosition() {
        return new Position(super.getPosition());
    }
}
