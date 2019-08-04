package it.unibo.oop18.cfc.Sprite;

import java.awt.Image;

/**
 * Class that represents a single image sprite.
 */
public class Sprite {

    private final Image image;

    /**
     * Creates {@code Sprite}.
     *
     * @param sheet where to take the single sprite
     * @param x coordinate to select the sprite
     * @param y coordinate to select the sprite
     */
    public Sprite(final SpriteSheet sheet, final int x, final int y) {
        this.image = sheet.getSingleSprite(x, y).getScaledInstance(SpriteSheet.SPRITE_SIZE_IN_GAME,
                                                                   SpriteSheet.SPRITE_SIZE_IN_GAME,
                                                                   Image.SCALE_SMOOTH);
    }

    /**
     * Gets the sprite image.
     *
     * @return the sprite {@link Image}
     */
    public Image getImage() {
        return this.image;
    }

}
