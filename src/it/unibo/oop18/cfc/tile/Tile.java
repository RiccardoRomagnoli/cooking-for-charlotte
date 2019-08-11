package it.unibo.oop18.cfc.tile;

import java.awt.Image;

/**
 * Tile class.
 */
public class Tile {

    private final Image image;

    /**
     * Instantiates a new tile.
     *
     * @param sheet the sheet
     * @param x     the x
     * @param y     the y
     */
    public Tile(final TileSheet sheet, final int x, final int y) {
        this.image = sheet.getSingleTile(x, y);
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public Image getImage() {
        return this.image;
    }
}
