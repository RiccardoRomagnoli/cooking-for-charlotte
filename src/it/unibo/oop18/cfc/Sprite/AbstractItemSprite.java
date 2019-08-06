package it.unibo.oop18.cfc.Sprite;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractItemSprite {

    private final List<ItemSprite> itemSprite;

    /**
     * Creates an {@code AbstractStationTile}.
     */
    public AbstractItemSprite() {
        this.itemSprite = new ArrayList<>();
    }

    /**
     * Gets the sprite about the single animation.
     *
     * @return a list of {@link Tile}
     */
    public List<ItemSprite> getItemSprite() {
        return this.itemSprite;
    }

    /**
     * Gets the number of tiles for the state of food.
     *
     * @return the size of the {@link Tile} list
     */
    public abstract int getItemSpriteNumber();

}