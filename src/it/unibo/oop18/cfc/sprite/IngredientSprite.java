package it.unibo.oop18.cfc.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class IngredientSprite.
 */
public class IngredientSprite {

    private static final int FOOD_SPRITES = 4;
    private static final int Y_LOCATION_BREAD = 1;
    private static final int Y_LOCATION_MEAT = 2;
    private static final int Y_LOCATION_LETTUCE = 4;
    private static final int Y_LOCATION_TOMATO = 3;
    private final List<List<ItemSprite>> ingredients;
    private final List<ItemSprite> breadSprite;
    private final List<ItemSprite> meatSprite;
    private final List<ItemSprite> lettuceSprite;
    private final List<ItemSprite> tomatoSprite;

    /**
     * Instantiates a new {@link IngredientSprite}.
     *
     * @param sheet the {@link ItemSpriteSheet} to get the images
     */
    public IngredientSprite(final ItemSpriteSheet sheet) {
        super();
        this.breadSprite = new ArrayList<>();
        this.meatSprite = new ArrayList<>();
        this.lettuceSprite = new ArrayList<>();
        this.tomatoSprite = new ArrayList<>();
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_BREAD))
                .collect(Collectors.toList()).forEach(a -> breadSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_MEAT))
                .collect(Collectors.toList()).forEach(a -> meatSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LETTUCE))
                .collect(Collectors.toList()).forEach(a -> lettuceSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_TOMATO))
                .collect(Collectors.toList()).forEach(a -> tomatoSprite.add(a));
        this.ingredients = new ArrayList<List<ItemSprite>>();
        ingredients.add(breadSprite);
        ingredients.add(meatSprite);
        ingredients.add(lettuceSprite);
        ingredients.add(tomatoSprite);
    }

    /**
     * Gets the food sprite number.
     *
     * @return the food sprite number
     */
    public int getFoodSpriteNumber() {
        return FOOD_SPRITES;
    }

    /**
     * Gets the list of ingredients sprite lists.
     *
     * @return the list of ingredients sprite lists
     */
    public List<List<ItemSprite>> getIngredientSprite() {
        return ingredients;
    }
}
