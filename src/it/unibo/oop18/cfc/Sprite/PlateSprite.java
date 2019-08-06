package it.unibo.oop18.cfc.Sprite;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlateSprite extends AbstractItemSprite {

    private static final int PLATE_SPRITES = 4;
    private static final int Y_LOCATION_MOVE_LEFT = 1;

    public PlateSprite(final ItemSpriteSheet sheet) {
        super();
        IntStream.range(0, PLATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, 1, 1)).collect(Collectors.toList())
        .forEach(a -> super.getItemSprite().add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        // TODO Auto-generated method stub
        return PLATE_SPRITES;
    }

}
