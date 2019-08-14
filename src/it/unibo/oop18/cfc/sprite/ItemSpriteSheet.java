package it.unibo.oop18.cfc.sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class that loads and stores a item sprite sheet from a path.
 */
public class ItemSpriteSheet {

    /** The item sprite width. */
    public static final int ITEM_SPRITE_WIDTH_IN_GAME = 32;

    /** The item sprite height. */
    public static final int ITEM_SPRITE_HEIGHT_IN_GAME = 26;

    private final BufferedImage sheet;

    /**
     * Creates {@link ItemSpriteSheet}.
     *
     * @param path to load the item sprite sheet
     * @throws IOException launched while loading
     */
    public ItemSpriteSheet(final String path) throws IOException {
        this.sheet = ImageIO.read(getClass().getResource(path));
    }

    /**
     * Gets a single item sprite taken from sheet.
     *
     * @param x coordinate to select the {@link ItemSprite}
     * @param y coordinate to select the {@link ItemSprite}
     * @return a buffered image of the {@link ItemSprite}
     */
    public BufferedImage getSingleItemSprite(final int x, final int y) {
        return this.sheet.getSubimage(x * ITEM_SPRITE_WIDTH_IN_GAME, y * ITEM_SPRITE_HEIGHT_IN_GAME,
                ITEM_SPRITE_WIDTH_IN_GAME, ITEM_SPRITE_HEIGHT_IN_GAME);
    }

}
