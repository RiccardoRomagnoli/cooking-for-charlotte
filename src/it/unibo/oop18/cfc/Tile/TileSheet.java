package it.unibo.oop18.cfc.Tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * Class that loads and stores a sprite sheet from a path.
 */
public class TileSheet {

    /**
     * It sets the sprite size used in game.
     */
    public static final int TILE_SIZE_IN_GAME = 64;
    private final BufferedImage sheet;

    /**
     * Creates {@code SpriteSheet}.
     *
     * @param path to load the sprite sheet
     * @throws IOException launched while loading
     */
    public TileSheet(final String path) throws IOException {
        this.sheet = ImageIO.read(getClass().getResource(path));
    }

    /**
     * Gets a single sprite taken from sheet.
     *
     * @param x coordinate to select the {@link Sprite}
     * @param y coordinate to select the {@link Sprite}
     * @return a buffered image of the {@link Sprite}
     */
    public BufferedImage getSingleTile(final int x, final int y) {
        return this.sheet.getSubimage(x * TILE_SIZE_IN_GAME,
                                      y * TILE_SIZE_IN_GAME,
                                      TILE_SIZE_IN_GAME, TILE_SIZE_IN_GAME);
    }

}
