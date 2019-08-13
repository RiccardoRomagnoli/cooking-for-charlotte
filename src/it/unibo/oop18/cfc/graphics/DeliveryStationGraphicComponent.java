package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.object.stations.DeliveryStation;
import it.unibo.oop18.cfc.tile.DeliveryStationTile;

/**
 * The Class DeliveryStationGraphicComponent.
 */
public class DeliveryStationGraphicComponent implements GraphicsComponent {

    private static final int DIVISION_BY_ZERO_PROTECTION = 1;
    private static final int FRAME_DELAY = Math.round(GameEngine.FPS / 15) + DIVISION_BY_ZERO_PROTECTION;
    private final DeliveryStation deliveryStation;
    private final DeliveryStationTile deliveryStationTile;

    private int frame;
    private int updateFrame;

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
        this.frame = 0;
        this.updateFrame = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        this.nextFrame();
        g.drawImage(this.deliveryStationTile.getTiles().get(this.frame).getImage(),
                AffineTransform.getTranslateInstance(this.deliveryStation.getPosition().getX(),
                        this.deliveryStation.getPosition().getY()),
                null);
    }

    private void nextFrame() {
        this.updateFrame++;
        if (this.updateFrame % FRAME_DELAY == 0) {
            this.frame++;
            this.updateFrame = 0;
            this.frame = this.frame >= this.deliveryStationTile.getTilesNumber() ? 0 : this.frame;
        }
    }
}
