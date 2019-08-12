package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.PlateStation;
import it.unibo.oop18.cfc.tile.PlateStationTile;

/**
 * The Class PlateStationGraphicComponent.
 */
public class PlateStationGraphicComponent implements GraphicsComponent {
    private final PlateStation plateStation;
    private final PlateStationTile plateStationTile;

    /**
     * Instantiates a new {@link PlateStationGraphicComponent}.
     *
     * @param plateStation     the {@link PlateStation}
     * @param plateStationTile the {@link PlateStationTile} to draw
     */
    public PlateStationGraphicComponent(final PlateStation plateStation, final PlateStationTile plateStationTile) {
        this.plateStation = plateStation;
        this.plateStationTile = plateStationTile;
    }

    /**
     * {@inheritDoc}.
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.plateStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.plateStation.getPosition().getX(), this.plateStation.getPosition().getY()), null);
    }
}
