package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Stations.TomatoStation;
import it.unibo.oop18.cfc.tile.TomatoStationTile;

public class TomatoStationGraphicComponent implements GraphicsComponent {

    private final TomatoStation tomatoStation;
    private final TomatoStationTile tomatoStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param tomatoStation       the logic of the door
     * @param tomatoStationTile door's sprite
     */
    public TomatoStationGraphicComponent(final TomatoStation tomatoStation, final TomatoStationTile tomatoStationTile) {
        this.tomatoStation = tomatoStation;
        this.tomatoStationTile = tomatoStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.tomatoStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.tomatoStation.getPosition().getX(), this.tomatoStation.getPosition().getY()), null);
    }
}
