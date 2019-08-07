package it.unibo.oop18.cfc.Sprite;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlateSprite extends AbstractItemSprite {

    private static final int PLATE_SPRITES = 1;
    private static final int Y_LOCATION_PLATE = 0;

    public PlateSprite(final ItemSpriteSheet sheet) {
        super();
        IntStream.range(0, PLATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_PLATE)).collect(Collectors.toList())
        .forEach(a -> super.getItemSprite().add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        return PLATE_SPRITES;
    }

}
