package it.unibo.oop18.cfc.object;

import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.util.Position;

/**
 * This class models a simple {@link GameObject}.
 */
public abstract class AbstractGameObject implements GameObject {

    private final Position position;

    /**
     * Creates a {@code AbstractGameObject}.
     * 
     * @param position object's position
     */
    public AbstractGameObject(final Position position) {
        this.position = position;
    }

    /**
     * {@inheritDoc}
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(this.getPosition().getX(), this.getPosition().getY(), TileSheet.TILE_SIZE_IN_GAME,
                TileSheet.TILE_SIZE_IN_GAME);
    }

}
