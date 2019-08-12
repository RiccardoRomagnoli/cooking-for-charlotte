package it.unibo.oop18.cfc.sprite;

import java.awt.Image;

/**
 * The Class ItemSprite.
 */
public class ItemSprite {
    private final Image image;

    /**
     * Creates {@link ItemSprite}.
     *
     * @param sheet where to take the single itemsprite
     * @param x     coordinate to select the itemsprite
     * @param y     coordinate to select the itemsprite
     */
    public ItemSprite(final ItemSpriteSheet sheet, final int x, final int y) {
        this.image = sheet.getSingleItemSprite(x, y).getScaledInstance(ItemSpriteSheet.ITEM_SPRITE_WIDTH_IN_GAME,
                ItemSpriteSheet.ITEM_SPRITE_HEIGHT_IN_GAME, Image.SCALE_SMOOTH);
    }

    /**
     * Gets the itemsprite image.
     *
     * @return the itemsprite {@link Image}
     */
    public Image getImage() {
        return this.image;
    }
}
