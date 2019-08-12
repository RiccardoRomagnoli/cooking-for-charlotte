package it.unibo.oop18.cfc.manager;

import java.io.IOException;

import it.unibo.oop18.cfc.sprite.IngredientSprite;
import it.unibo.oop18.cfc.sprite.ItemSpriteSheet;
import it.unibo.oop18.cfc.sprite.LoadingSprite;
import it.unibo.oop18.cfc.sprite.PlateSprite;

/**
 * The Class ItemManager.
 */
public class ItemManager {

    private final PlateSprite plateSprites;
    private final IngredientSprite foodSprites;
    private final LoadingSprite loadingSprites;

    /**
     * Instantiates a new {@link ItemManager}.
     *
     * @param path the path of the item image
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ItemManager(final String path) throws IOException {
        final ItemSpriteSheet is = new ItemSpriteSheet(path);
        this.plateSprites = new PlateSprite(is);
        this.foodSprites = new IngredientSprite(is);
        this.loadingSprites = new LoadingSprite(is);
    }

    /**
     * Gets the plate sprites.
     *
     * @return the {@link PlateSprite}
     */
    public PlateSprite getPlateSprites() {
        return plateSprites;
    }

    /**
     * Gets the food sprites.
     *
     * @return the {@link IngredientSprite}
     */
    public IngredientSprite getFoodSprites() {
        return foodSprites;
    }

    /**
     * Gets the loading sprites.
     *
     * @return the {@link LoadingSprite}
     */
    public LoadingSprite getLoadingSprites() {
        return loadingSprites;
    }
}
