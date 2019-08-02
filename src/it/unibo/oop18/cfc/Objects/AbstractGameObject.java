package it.unibo.oop18.cfc.Objects;

import java.awt.geom.Rectangle2D;

import it.unibo.oop18.cfc.Tile.Tile;
import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Util.Position;

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
    @Override
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
