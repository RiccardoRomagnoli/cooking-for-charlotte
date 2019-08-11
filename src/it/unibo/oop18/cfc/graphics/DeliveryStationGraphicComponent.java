package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.Stations.DeliveryStation;
import it.unibo.oop18.cfc.tile.DeliveryStationTile;

public class DeliveryStationGraphicComponent implements GraphicsComponent {
    private final DeliveryStation deliveryStation;
    private final DeliveryStationTile deliveryStationTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param deliveryStation       the logic of the door
     * @param deliveryStationTile door's sprite
     */
    public DeliveryStationGraphicComponent(final DeliveryStation deliveryStation,
            final DeliveryStationTile deliveryStationTile) {
        this.deliveryStation = deliveryStation;
        this.deliveryStationTile = deliveryStationTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.deliveryStationTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                this.deliveryStation.getPosition().getX(), this.deliveryStation.getPosition().getY()), null);
    }
}
