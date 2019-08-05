package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.BreadStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.BreadStationTile;
import it.unibo.oop18.cfc.Util.Position;

/**
 * Managing of the place where food is processed.
 *
 */
public class BreadStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
     * @param breadStationTile image
     */
    public BreadStation(final Position position, final BreadStationTile breadStationTile) {
        super(position);
        this.graphicComponent = new BreadStationGraphicComponent(this, breadStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}
