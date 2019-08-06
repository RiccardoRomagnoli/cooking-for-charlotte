package it.unibo.oop18.cfc.Tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CounterTile extends AbstractStationTile {

    private static final int Y_LOCATION = 3;
    private static final int N_TILES = 6;

    /**
     * Creates a {@code CookerTile} container.
     *
     * @param sheet {@link TileSheet} where to take the {@link Tile}
     */
    public CounterTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, a, Y_LOCATION)).collect(Collectors.toList())
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
