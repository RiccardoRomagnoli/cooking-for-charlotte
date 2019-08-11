package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Class ChoppingStationTile.
 */
public class ChoppingStationTile extends AbstractStationTile {

    private static final int Y_LOCATION = 1;
    private static final int N_TILES = 3;

    /**
     * Instantiates a new chopping station tile.
     *
     * @param sheet the sheet
     */
    public ChoppingStationTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, a, Y_LOCATION)).collect(Collectors.toList())
                .forEach(a -> super.getTiles().add(a));
    }

    /**
    * {@inheritDoc}
    */
    public int getTilesNumber() {
        return N_TILES;
    }

}
