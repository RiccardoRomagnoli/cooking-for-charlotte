package it.unibo.oop18.cfc.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlateSprite extends AbstractItemSprite {

    private static final int PLATE_SPRITES = 2;
    private static final int Y_LOCATION_PLATE = 0;

    private final List<ItemSprite> plateSprite;

    public PlateSprite(final ItemSpriteSheet sheet) {
        super();
        this.plateSprite = new ArrayList<>();
        IntStream.range(0, PLATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_PLATE)).collect(Collectors.toList())
        .forEach(a -> plateSprite.add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        return PLATE_SPRITES;
    }

    public List<ItemSprite> getPlateSprite() {
        return plateSprite;
    }

}
