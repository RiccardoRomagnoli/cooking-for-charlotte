package it.unibo.oop18.cfc.sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoadingSprite extends AbstractItemSprite {

    private static final int LOAD_SPRITES = 4;
    private static final int Y_LOCATION_LOADING = 6;

    private final List<ItemSprite> loadingSprites;

    public LoadingSprite(final ItemSpriteSheet sheet) {
        super();
        this.loadingSprites = new ArrayList<>();
        IntStream.range(0, LOAD_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LOADING))
                .collect(Collectors.toList()).forEach(a -> loadingSprites.add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        return LOAD_SPRITES;
    }

    public List<ItemSprite> getLoadingSprite() {
        return loadingSprites;
    }

}
