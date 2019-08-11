package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Stations.MeatStation;
import it.unibo.oop18.cfc.tile.MeatStationTile;

/**
 * The Class MeatStationGraphicComponent.
 */
public class MeatStationGraphicComponent implements GraphicsComponent {

    private final MeatStation meatStation;
    private final MeatStationTile meatStationTile;

    /**
     * Instantiates a new meat station graphic component.
     *
     * @param meatStation the meat station
     * @param meatStationTile the meat station tile
     */
    public MeatStationGraphicComponent(final MeatStation meatStation, final MeatStationTile meatStationTile) {
        this.meatStation = meatStation;
        this.meatStationTile = meatStationTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.meatStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.meatStation.getPosition().getX(), this.meatStation.getPosition().getY()), null);
    }
}
