package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TomatoStationTile extends AbstractStationTile {

    private static final int Y_LOCATION = 5;
    private static final int X_LOCATION = 3;
    private static final int N_TILES = 1;

    /**
     * Creates a {@code CookerTile} container.
     *
     * @param sheet {@link TileSheet} where to take the {@link Tile}
     */
    public TomatoStationTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, X_LOCATION, Y_LOCATION)).collect(Collectors.toList())
                .forEach(a -> super.getTiles().add(a));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTilesNumber() {
        return N_TILES;
    }

}
