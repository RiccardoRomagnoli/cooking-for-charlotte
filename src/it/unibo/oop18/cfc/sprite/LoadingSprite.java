package it.unibo.oop18.cfc.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class LoadingSprite.
 */
public class LoadingSprite {

    private static final int LOAD_SPRITES = 4;
    private static final int Y_LOCATION_LOADING = 6;

    private final List<ItemSprite> loadingSprites;

    /**
     * Instantiates a new {@link LoadingSprite}.
     *
     * @param sheet the {@link ItemSpriteSheet} to take images
     */
    public LoadingSprite(final ItemSpriteSheet sheet) {
        super();
        this.loadingSprites = new ArrayList<>();
        IntStream.range(0, LOAD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LOADING))
                .collect(Collectors.toList()).forEach(a -> loadingSprites.add(a));
    }

    /**
     * Gets the loading sprite number.
     *
     * @return the loading sprite number
     */
    public int getLoadingSpriteNumber() {
        return LOAD_SPRITES;
    }

    /**
     * Gets the loading sprite.
     *
     * @return the loading sprite
     */
    public List<ItemSprite> getLoadingSprite() {
        return loadingSprites;
    }

}
