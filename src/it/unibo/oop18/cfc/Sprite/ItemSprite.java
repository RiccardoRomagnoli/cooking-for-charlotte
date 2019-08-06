package it.unibo.oop18.cfc.Sprite;

import java.awt.Image;

public class ItemSprite {
    private final Image image;

    /**
     * Creates {@code Sprite}.
     *
     * @param sheet where to take the single sprite
     * @param x coordinate to select the sprite
     * @param y coordinate to select the sprite
     */
    public ItemSprite(final ItemSpriteSheet sheet, final int x, final int y) {
        this.image = sheet.getSingleItemSprite(x, y).getScaledInstance(ItemSpriteSheet.ITEM_SPRITE_SIZE_IN_GAME,
                                                                   ItemSpriteSheet.ITEM_SPRITE_SIZE_IN_GAME,
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
