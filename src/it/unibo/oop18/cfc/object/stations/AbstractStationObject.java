package it.unibo.oop18.cfc.object.stations;

import it.unibo.oop18.cfc.object.AbstractGameObject;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class AbstractStationObject.
 */
public abstract class AbstractStationObject extends AbstractGameObject implements Station {

    /**
     * Instantiates a new {@link AbstractStationObject}.
     *
     * @param position the position
     */
    public AbstractStationObject(final Position position) {
        super(position);
    }

    /**
     *  {@inheritDoc}}
     */
    public Position getPosition() {
        return new Position(super.getPosition());
    }
}
