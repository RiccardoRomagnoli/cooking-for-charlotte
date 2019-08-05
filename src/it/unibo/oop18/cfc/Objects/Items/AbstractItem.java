package it.unibo.oop18.cfc.Objects.Items;

import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.Objects.AbstractGameObject;
import it.unibo.oop18.cfc.Util.Position;

public abstract class AbstractItem extends AbstractGameObject {

    private static final int DIMITEM = 50;

    public AbstractItem(final Position position) {
        super(position);
    }

    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(this.getPosition().getX(), this.getPosition().getY(), DIMITEM,
                DIMITEM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Position getPosition() {
        return new Position(super.getPosition());
    }
}
