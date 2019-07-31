package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import it.unibo.oop18.cfc.Objects.GameObject;


/**
 * This class represents still object's graphic component and models {@link GraphicsComponent}.
 */
public class StationObjectGraphicComponent implements GraphicsComponent {

    private final Sprite sprite;
    private final GameObject object;

    /**
     * Creates a {@code StillObjectGraphicComponent}.
     * 
     * @param sprite block's sprite
     * @param object reference
     */
    public StationObjectGraphicComponent(final GameObject object, final Sprite sprite) {
        this.sprite = sprite;
        this.object = object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(this.sprite.getImage(),
                AffineTransform.getTranslateInstance(this.object.getPosition().getX(),
                                                     this.object.getPosition().getY()), null);
    }
}
