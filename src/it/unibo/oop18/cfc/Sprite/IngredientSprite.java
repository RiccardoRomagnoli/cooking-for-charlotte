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
    private static final int STATE_SPRITES = 2;

    private final List<ItemSprite> breadSprite;
    private final List<ItemSprite> meatSprite;
    private final List<ItemSprite> lettuceSprite;
    private final List<ItemSprite> tomatoSprite;

    public IngredientSprite(final ItemSpriteSheet sheet) {
        super();
        this.breadSprite = new ArrayList<>();
        this.meatSprite = new ArrayList<>();
        this.lettuceSprite = new ArrayList<>();
        this.tomatoSprite = new ArrayList<>();

        IntStream.range(X_LOCATION_STATE_INGREDIENT, STATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_STATE_INGREDIENT)).collect(Collectors.toList())
        .forEach(a -> super.getItemSprite().add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_BREAD)).collect(Collectors.toList())
        .forEach(a -> breadSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_MEAT)).collect(Collectors.toList())
        .forEach(a -> meatSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LETTUCE)).collect(Collectors.toList())
        .forEach(a -> lettuceSprite.add(a));
        IntStream.range(0, FOOD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_TOMATO)).collect(Collectors.toList())
        .forEach(a -> tomatoSprite.add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        return FOOD_SPRITES;
        }

    /**
     * @return the breadSprite
     */
    public List<ItemSprite> getBreadSprite() {
        return breadSprite;
    }

    /**
     * @return the meatSprite
     */
    public List<ItemSprite> getMeatSprite() {
        return meatSprite;
    }

    /**
     * @return the lettuceSprite
     */
    public List<ItemSprite> getLettuceSprite() {
        return lettuceSprite;
    }

    /**
     * @return the tomatoSprite
     */
    public List<ItemSprite> getTomatoSprite() {
        return tomatoSprite;
    }
}
