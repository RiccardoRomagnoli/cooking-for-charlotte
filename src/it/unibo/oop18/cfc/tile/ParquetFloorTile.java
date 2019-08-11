package it.unibo.oop18.cfc.tile;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.oop18.cfc.tilemap.TileType;

/**
 * The Class ParquetFloorTile.
 */
public class ParquetFloorTile extends AbstractFloorTile {

    private static final int N_TILES = 2;

    /**
     * Instantiates a new parquet floor tile.
     *
     * @param sheet the sheet
     */
    public ParquetFloorTile(final TileSheet sheet) {
        super();
        IntStream.range(0, N_TILES).mapToObj(a -> new Tile(sheet, a, TileType.PARQUETLEFTFLOOR.getPosY()))
                .collect(Collectors.toList()).forEach(a -> super.getTiles().add(a));
    }

    /**
     * {@inheritDoc}
     */
    public int getTilesNumber() {
        return N_TILES;
    }

}
