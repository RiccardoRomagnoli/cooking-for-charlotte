package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class TomatoStationTile.
 */
public class TomatoStationTile extends AbstractStationTile {

    private static final int Y_LOCATION = 5;
    private static final int X_LOCATION = 3;
    private static final int N_TILES = 1;

    /**
     * Instantiates a new tomato station tile.
     *
     * @param sheet the sheet
     */
    public TomatoStationTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, X_LOCATION, Y_LOCATION)).collect(Collectors.toList())
                .forEach(a -> super.getTiles().add(a));
    }

    /**
    * {@inheritDoc}
    */
    public int getTilesNumber() {
        return N_TILES;
    }

}
