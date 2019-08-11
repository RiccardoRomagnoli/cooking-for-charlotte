package it.unibo.oop18.cfc.object.Stations;

import it.unibo.oop18.cfc.object.AbstractGameObject;
import it.unibo.oop18.cfc.util.Position;

/**
 *  This class models a still {@link AbstractGameObject}.
 */
public abstract class AbstractStationObject extends AbstractGameObject implements Station {

    /**
     * Creates an {@code AbstractStationObject}.
     * 
     * @param position object's position
     */
    public AbstractStationObject(final Position position) {
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
