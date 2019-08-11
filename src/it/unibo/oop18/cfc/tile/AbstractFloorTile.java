package it.unibo.oop18.cfc.tile;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFloorTile {

    private final List<Tile> tiles;

    /**
     * Creates an {@code AbstractStationTile}.
     */
    public AbstractFloorTile() {
        this.tiles = new ArrayList<>();
    }

    /**
     * Gets the sprite about the single animation.
     *
     * @return a list of {@link Tile}
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }

    /**
     * Gets the number of tiles for the animation.
     *
     * @return the size of the {@link Tile} list
     */
    public abstract int getTilesNumber();
}
