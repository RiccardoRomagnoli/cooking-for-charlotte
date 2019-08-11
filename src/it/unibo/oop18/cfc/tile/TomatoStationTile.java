package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.tilemap.TileType;

/**
 * The Class TomatoStationTile.
 */
public class TomatoStationTile extends AbstractStationTile {

    private static final int N_TILES = 1;

    /**
     * Instantiates a new tomato station tile.
     *
     * @param sheet the sheet
     */
    public TomatoStationTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, a, TileType.TOMATOSTATION.getPosY()))
                .collect(Collectors.toList()).forEach(a -> super.getTiles().add(a));
    }

    /**
     * {@inheritDoc}
     */
    public int getTilesNumber() {
        return N_TILES;
    }

}
