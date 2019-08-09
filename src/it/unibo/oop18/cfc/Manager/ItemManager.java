package it.unibo.oop18.cfc.Manager;

import java.io.IOException;

import it.unibo.oop18.cfc.Sprite.IngredientSprite;
import it.unibo.oop18.cfc.Sprite.ItemSpriteSheet;
import it.unibo.oop18.cfc.Sprite.LoadingSprite;
import it.unibo.oop18.cfc.Sprite.PlateSprite;

public class ItemManager {

    private final PlateSprite plateSprites;
    private final IngredientSprite foodSprites;
    private final LoadingSprite loadingSprites;
    
    public ItemManager(final String path) throws IOException {
        final ItemSpriteSheet is = new ItemSpriteSheet(path);
        this.plateSprites = new PlateSprite(is);
        this.foodSprites = new IngredientSprite(is);
        this.loadingSprites = new LoadingSprite(is);
    }

    /**
     * @return the plateSprite
     */
    public PlateSprite getPlateSprites() {
        return plateSprites;
    }

    public IngredientSprite getFoodSprites() {
        return foodSprites;
    }

    public LoadingSprite getLoadingSprites() {
        return loadingSprites;
    }
}
