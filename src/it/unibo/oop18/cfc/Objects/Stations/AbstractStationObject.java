package it.unibo.oop18.cfc.Objects.Stations;

import it.unibo.oop18.cfc.Objects.AbstractGameObject;
import it.unibo.oop18.cfc.Util.Position;

/**
 *  This class models a still {@link AbstractGameObject}.
 */
public abstract class AbstractStationObject extends AbstractGameObject {

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
