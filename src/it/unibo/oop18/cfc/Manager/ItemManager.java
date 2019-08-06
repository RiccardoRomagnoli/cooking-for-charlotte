package it.unibo.oop18.cfc.Manager;

import java.io.IOException;

import it.unibo.oop18.cfc.Sprite.FoodSprite;
import it.unibo.oop18.cfc.Sprite.ItemSpriteSheet;
import it.unibo.oop18.cfc.Sprite.PlateSprite;

public class ItemManager {

    private final PlateSprite plateSprites;
    private final FoodSprite foodSprites;

    public ItemManager(final String path) throws IOException {
        final ItemSpriteSheet is = new ItemSpriteSheet(path);
        this.plateSprites = new PlateSprite(is);
        this.foodSprites = new FoodSprite(is);
    }

    /**
     * @return the plateSprite
     */
    public PlateSprite getPlateSprites() {
        return plateSprites;
    }

    public FoodSprite getFoodSprites() {
        return foodSprites;
    }

}
