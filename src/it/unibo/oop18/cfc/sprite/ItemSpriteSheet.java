package it.unibo.oop18.cfc.sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class that loads and stores a sprite sheet from a path.
 */
public class ItemSpriteSheet {

    /**
     * It sets the sprite size used in game.
     */
    public static final int ITEM_SPRITE_WIDTH_IN_GAME = 30;
    public static final int ITEM_SPRITE_HEIGHT_IN_GAME = 20;
    private final BufferedImage sheet;

    /**
     * Creates {@code SpriteSheet}.
     *
     * @param path to load the sprite sheet
     * @throws IOException launched while loading
     */
    public ItemSpriteSheet(final String path) throws IOException {
        this.sheet = ImageIO.read(getClass().getResource(path));
    }

    /**
     * Gets a single sprite taken from sheet.
     *
     * @param x coordinate to select the {@link Sprite}
     * @param y coordinate to select the {@link Sprite}
     * @return a buffered image of the {@link Sprite}
     */
    public BufferedImage getSingleItemSprite(final int x, final int y) {
        return this.sheet.getSubimage(x * ITEM_SPRITE_WIDTH_IN_GAME, y * ITEM_SPRITE_HEIGHT_IN_GAME,
                ITEM_SPRITE_WIDTH_IN_GAME, ITEM_SPRITE_HEIGHT_IN_GAME);
    }

}
