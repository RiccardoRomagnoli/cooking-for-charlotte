package it.unibo.oop18.cfc.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IngredientSprite extends AbstractItemSprite {

    private static final int FOOD_SPRITES = 3;
    private static final int Y_LOCATION_BREAD = 1;
    private static final int Y_LOCATION_MEAT = 2;
    private static final int Y_LOCATION_LETTUCE = 4;
    private static final int Y_LOCATION_TOMATO = 3;
    private static final int Y_LOCATION_STATE_INGREDIENT = 0;
    private static final int X_LOCATION_STATE_INGREDIENT = 1;
    private static final int INGREDIENT_STATE_SPRITES = 2;
    private final List<List<ItemSprite>> ingredients;
    private final List<ItemSprite> breadSprite;
    private final List<ItemSprite> meatSprite;
    private final List<ItemSprite> lettuceSprite;
    private final List<ItemSprite> tomatoSprite;
    private final List<ItemSprite> stateSprite;

    public IngredientSprite(final ItemSpriteSheet sheet) {
        super();
        this.breadSprite = new ArrayList<>();
        this.meatSprite = new ArrayList<>();
        this.lettuceSprite = new ArrayList<>();
        this.tomatoSprite = new ArrayList<>();
        this.stateSprite = new ArrayList<>();
        IntStream.rangeClosed(X_LOCATION_STATE_INGREDIENT, INGREDIENT_STATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_STATE_INGREDIENT)).collect(Collectors.toList())
        .forEach(a -> stateSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_BREAD)).collect(Collectors.toList())
        .forEach(a -> breadSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_MEAT)).collect(Collectors.toList())
        .forEach(a -> meatSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LETTUCE)).collect(Collectors.toList())
        .forEach(a -> lettuceSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_TOMATO)).collect(Collectors.toList())
        .forEach(a -> tomatoSprite.add(a));
        this.ingredients = new ArrayList<List<ItemSprite>>();
        ingredients.add(breadSprite);
        ingredients.add(meatSprite);
        ingredients.add(lettuceSprite);
        ingredients.add(tomatoSprite);
    }

    @Override
    public int getItemSpriteNumber() {
        return FOOD_SPRITES;
        }

    public List<List<ItemSprite>> getIngredientSprite() {
        return ingredients;
    }

    /**
     * @return the stateSprite
     */
    public List<ItemSprite> getStateSprite() {
        return stateSprite;
    }
}
