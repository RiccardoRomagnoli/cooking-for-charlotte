package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Stations.MeatStation;
import it.unibo.oop18.cfc.tile.MeatStationTile;

public class MeatStationGraphicComponent implements GraphicsComponent {

    private final MeatStation meatStation;
    private final MeatStationTile meatStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param meatStation       the logic of the door
     * @param meatStationTile door's sprite
     */
    public MeatStationGraphicComponent(final MeatStation meatStation, final MeatStationTile meatStationTile) {
        this.meatStation = meatStation;
        this.meatStationTile = meatStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.meatStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.meatStation.getPosition().getX(), this.meatStation.getPosition().getY()), null);
    }
}
