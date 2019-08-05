package it.unibo.oop18.cfc.Objects.Stations;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Graphics.TomatoStationGraphicComponent;
import it.unibo.oop18.cfc.Graphics.GraphicsComponent;
import it.unibo.oop18.cfc.Tile.TomatoStationTile;
import it.unibo.oop18.cfc.Util.Position;

/**
 * Managing of the place where food is processed.
 *
 */
public class TomatoStation extends AbstractStationObject {

    private final GraphicsComponent graphicComponent;
    /**
     * Constructor method.
     * @param position entity
     * @param breadStationTile image
     */
    public TomatoStation(final Position position, final TomatoStationTile breadStationTile) {
        super(position);
        this.graphicComponent = new TomatoStationGraphicComponent(this, breadStationTile);
    }

    @Override
    public void draw(final Graphics2D g) {
        this.graphicComponent.draw(g);
    }

}
