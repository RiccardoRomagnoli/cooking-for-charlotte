package it.unibo.oop18.cfc.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class TileSheet.
 */
public class TileSheet {

    /** The size of the tiles in game. */
    public static final int TILE_SIZE_IN_GAME = 64;
    private final BufferedImage sheet;

    /**
     * Instantiates a new tile sheet.
     *
     * @param path the path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public TileSheet(final String path) throws IOException {
        this.sheet = ImageIO.read(getClass().getResource(path));
    }

    /**
     * Gets the single tile.
     *
     * @param x the x
     * @param y the y
     * @return the single tile
     */
    public BufferedImage getSingleTile(final int x, final int y) {
        return this.sheet.getSubimage(x * TILE_SIZE_IN_GAME,
                                      y * TILE_SIZE_IN_GAME,
                                      TILE_SIZE_IN_GAME, TILE_SIZE_IN_GAME);
    }

}
