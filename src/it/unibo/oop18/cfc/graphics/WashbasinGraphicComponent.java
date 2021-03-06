package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.object.stations.Washbasin;
import it.unibo.oop18.cfc.tile.WashbasinTile;

/**
 * The Class WashbasinGraphicComponent.
 */
public class WashbasinGraphicComponent implements GraphicsComponent {
    private final Washbasin washbasin;
    private final WashbasinTile washbasinTile;

    /**
     * Instantiates a new {@link WashbasinGraphicComponent}.
     *
     * @param washbasin     the {@link Washbasin}
     * @param washbasinTile the {@link WashbasinTile} to draw
     */
    public WashbasinGraphicComponent(final Washbasin washbasin, final WashbasinTile washbasinTile) {
        this.washbasin = washbasin;
        this.washbasinTile = washbasinTile;
    }

    /**
     * {@inheritDoc}
     */
    public void draw(final Graphics2D g) {
        g.drawImage(this.washbasinTile.getTiles().get(0).getImage(), AffineTransform
                .getTranslateInstance(this.washbasin.getPosition().getX(), this.washbasin.getPosition().getY()), null);
    }
}
