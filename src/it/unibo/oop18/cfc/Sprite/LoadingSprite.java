package it.unibo.oop18.cfc.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoadingSprite extends AbstractItemSprite{

    private static final int LOADING_SPRITES = 4;
    private static final int Y_LOCATION_LOADING = 6;

    private final List<ItemSprite> loadingSprite;

    public LoadingSprite(final ItemSpriteSheet sheet) {
        super();
        this.loadingSprite = new ArrayList<>();
        IntStream.range(0, LOADING_SPRITES).mapToObj(a -> new ItemSprite(sheet, a, Y_LOCATION_LOADING)).collect(Collectors.toList())
        .forEach(a -> loadingSprite.add(a));
    }

    @Override
    public int getItemSpriteNumber() {
        return LOADING_SPRITES;
    }

    public List<ItemSprite> getLoadingSprite() {
        return loadingSprite;
    }

}
