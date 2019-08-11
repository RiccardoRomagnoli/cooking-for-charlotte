package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Stations.PlateStation;
import it.unibo.oop18.cfc.tile.PlateStationTile;

/**
 * This class represents still object's graphic component and models
 * {@link GraphicsComponent}.
 */
public class PlateStationGraphicComponent implements GraphicsComponent {
    private final PlateStation plateStation;
    private final PlateStationTile plateStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param plateStation     the logic of the door
     * @param plateStationTile door's sprite
     */
    public PlateStationGraphicComponent(final PlateStation plateStation, final PlateStationTile plateStationTile) {
        this.plateStation = plateStation;
        this.plateStationTile = plateStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.plateStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.plateStation.getPosition().getX(), this.plateStation.getPosition().getY()), null);
    }
}
