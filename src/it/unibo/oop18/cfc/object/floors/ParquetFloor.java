package it.unibo.oop18.cfc.object.floors;

import java.awt.Graphics2D;
import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.ParquetFloorGraphicComponent;
import it.unibo.oop18.cfc.tile.ParquetFloorTile;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Class ParquetFloor.
 */
public class ParquetFloor extends AbstractFloorObject {

    private final GraphicsComponent graphicComponent;

    /**
     * Instantiates a new {@link ParquetFloor}.
     *
     * @param position the {@link Position} to set
     * @param parquetFloorTile the {@link ParquetFloorTile} to draw
     */
    public ParquetFloor(final Position position, final ParquetFloorTile parquetFloorTile) {
        super(position);
        this.graphicComponent = new ParquetFloorGraphicComponent(this, parquetFloorTile);
    }

    /**
    * {@inheritDoc}
    */
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}
