package it.unibo.oop18.cfc.tile;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class AbstractFloorTile.
 */
public abstract class AbstractFloorTile {

    private final List<Tile> tiles;

    /**
     * Instantiates a new abstract floor tile.
     */
    public AbstractFloorTile() {
        this.tiles = new ArrayList<>();
    }

    /**
     * Gets the tiles.
     *
     * @return the tiles
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     * Gets the tiles number.
     *
     * @return the tiles number
     */
    public abstract int getTilesNumber();
}
