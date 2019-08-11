package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.TomatoStation;
import it.unibo.oop18.cfc.tile.TomatoStationTile;

/**
 * The Class TomatoStationGraphicComponent.
 */
public class TomatoStationGraphicComponent implements GraphicsComponent {

    private final TomatoStation tomatoStation;
    private final TomatoStationTile tomatoStationTile;


    /**
     * Instantiates a new tomato station graphic component.
     *
     * @param tomatoStation the tomato station
     * @param tomatoStationTile the tomato station tile
     */
    public TomatoStationGraphicComponent(final TomatoStation tomatoStation, final TomatoStationTile tomatoStationTile) {
        this.tomatoStation = tomatoStation;
        this.tomatoStationTile = tomatoStationTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.tomatoStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.tomatoStation.getPosition().getX(), this.tomatoStation.getPosition().getY()), null);
    }
}
