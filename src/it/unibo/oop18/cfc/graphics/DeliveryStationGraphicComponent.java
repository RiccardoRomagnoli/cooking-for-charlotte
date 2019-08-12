package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.DeliveryStation;
import it.unibo.oop18.cfc.tile.DeliveryStationTile;

/**
 * The Class DeliveryStationGraphicComponent.
 */
public class DeliveryStationGraphicComponent implements GraphicsComponent {
    private final DeliveryStation deliveryStation;
    private final DeliveryStationTile deliveryStationTile;

    /**
     * Instantiates a new {@link DeliveryStationGraphicComponent}.
     *
     * @param deliveryStation     the {@link DeliveryStation}
     * @param deliveryStationTile the {@link DeliveryStationTile} to draw
     */
    public DeliveryStationGraphicComponent(final DeliveryStation deliveryStation,
            final DeliveryStationTile deliveryStationTile) {
        this.deliveryStation = deliveryStation;
        this.deliveryStationTile = deliveryStationTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.deliveryStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.deliveryStation.getPosition().getX(), this.deliveryStation.getPosition().getY()), null);
    }
}
