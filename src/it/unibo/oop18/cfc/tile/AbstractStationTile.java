package it.unibo.oop18.cfc.tile;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class AbstractStationTile.
 */
public abstract class AbstractStationTile {

    private final List<Tile> tiles;


    /**
     * Instantiates a new abstract station tile.
     */
    public AbstractStationTile() {
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