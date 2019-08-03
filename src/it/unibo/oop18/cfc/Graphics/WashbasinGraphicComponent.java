package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.Stations.Washbasin;
import it.unibo.oop18.cfc.Tile.WashbasinTile;

public class WashbasinGraphicComponent implements GraphicsComponent {
    private final Washbasin washbasin;
    private final WashbasinTile washbasinTile;

    /**
     * Creates a {@code DoorGraphicComponent}.
     * 
     * @param washbasin     the logic of the door
     * @param washbasinTile door's sprite
     */
    public WashbasinGraphicComponent(final Washbasin washbasin, final WashbasinTile washbasinTile) {
        this.washbasin = washbasin;
        this.washbasinTile = washbasinTile;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        if (this.washbasin.isWashed()) {
            g.drawImage(this.washbasinTile.getTiles().get(1).getImage(), AffineTransform.getTranslateInstance(
                    this.washbasin.getPosition().getX(), this.washbasin.getPosition().getY()), null);
        } else {
            g.drawImage(this.washbasinTile.getTiles().get(0).getImage(), AffineTransform.getTranslateInstance(
                    this.washbasin.getPosition().getX(), this.washbasin.getPosition().getY()), null);
        }
    }
}
