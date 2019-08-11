package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.tilemap.TileType;


/**
 * The Class PlateStationTile.
 */
public class PlateStationTile extends AbstractStationTile{

    private static final int N_TILES = 1;

    /**
     * Instantiates a new plate station tile.
     *
     * @param sheet the sheet
     */
    public PlateStationTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, a, TileType.PLATESTATION.getPosY()))
                                     .collect(Collectors.toList())
                                     .forEach(a -> super.getTiles().add(a));
    }

    /**
    * {@inheritDoc}
    */
    public int getTilesNumber() {
        return N_TILES;
    }

}
