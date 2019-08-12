package it.unibo.oop18.cfc.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class PlateSprite.
 */
public class PlateSprite {

    private static final int PLATE_SPRITES = 2;
    private static final int Y_LOCATION_PLATE = 0;

    private final List<ItemSprite> plateSprites;

    /**
     * Instantiates a new {@link PlateSprite}.
     *
     * @param sheet the {@link ItemSpriteSheet} to get the images
     */
    public PlateSprite(final ItemSpriteSheet sheet) {
        super();
        this.plateSprites = new ArrayList<>();
        IntStream.range(0, PLATE_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_PLATE))
                .collect(Collectors.toList()).forEach(a -> plateSprites.add(a));
    }

    /**
     * Gets the plate sprite number.
     *
     * @return the plate sprite number
     */
    public int getPlateSpriteNumber() {
        return PLATE_SPRITES;
    }

    /**
     * Gets the plate sprite list.
     *
     * @return the plate sprite
     */
    public List<ItemSprite> getPlateSprite() {
        return plateSprites;
    }

}
