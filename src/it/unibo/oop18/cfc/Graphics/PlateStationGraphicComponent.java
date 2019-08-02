package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.GameObject;
import it.unibo.oop18.cfc.Tile.Tile;


/**
 * This class represents still object's graphic component and models {@link GraphicsComponent}.
 */
public class PlateStationGraphicComponent implements GraphicsComponent {

    private final Tile tile;
    private final GameObject object;

    /**
     * Creates a {@code StillObjectGraphicComponent}.
     * 
     * @param sprite block's sprite
     * @param object reference
     */
    public PlateStationGraphicComponent(final GameObject object, final Tile tile) {
        this.tile = tile;
        this.object = object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.tile.getImage(),
                AffineTransform.getTranslateInstance(this.object.getPosition().getX(),
                                                     this.object.getPosition().getY()), null);
    }
}
