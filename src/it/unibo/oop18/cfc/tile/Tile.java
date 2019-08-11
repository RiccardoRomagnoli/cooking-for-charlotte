package it.unibo.oop18.cfc.tile;

import java.awt.Image;

/**
 * Tile class.
 */
public class Tile {

    private final Image image;

    /**
     * Creates {@code Sprite}.
     *
     * @param sheet where to take the single sprite
     * @param x coordinate to select the sprite
     * @param y coordinate to select the sprite
     */
    public Tile(final TileSheet sheet, final int x, final int y) {
        this.image = sheet.getSingleTile(x, y);
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
