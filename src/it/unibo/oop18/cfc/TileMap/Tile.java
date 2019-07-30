package it.unibo.oop18.cfc.TileMap;

import java.awt.image.BufferedImage;
import java.util.Optional;

/**
 * Tile class.
 */
public class Tile {

    private final BufferedImage image;
    private final Optional<TileType> type;
    public static final int SPRITE_SIZE = 64;

    /**
     * Constructor of the class.
     * 
     * @param image The image of the tile
     * @param type  The type of the tile
     */
    public Tile(final BufferedImage image, final TileType type) {
        this.image = image;
        this.type = Optional.ofNullable(type);
    }

    public Tile(final BufferedImage image) {
        this.image = image;
        this.type = Optional.empty();
    }

    /**
     * Get the image of the tile.
     * 
     * @return image The image of the tile
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Get the type of the tile.
     * 
     * @return type The type of the tile
     */
    public Optional<TileType> getType() {
        return type;
    }
}
