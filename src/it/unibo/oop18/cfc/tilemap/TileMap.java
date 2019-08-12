package it.unibo.oop18.cfc.tilemap;

import java.util.Set;

import it.unibo.oop18.cfc.util.Position;

/**
 * This interface declares the method of a {@link TileMap}.
 */
interface TileMap {

    /**
     * Load the map of the game based of the bitmap.
     * 
     * @param s The name of the file with the bitmap
     */
    void loadMap();

    /**
     * Get the set of chopping station {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getChoppingStationPosition();

    /**
     * Get the set of cooker station {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getCookerPosition();

    /**
     * Get the set of counter {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getCounterPosition();

    /**
     * Get the set of delivery {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getDeliveryStationPosition();

    /**
     * Get the set of bread station {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getBreadStationPosition();

    /**
     * Get the set of meat station {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getMeatStationPosition();

    /**
     * Get the set of tomato tation {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getTomatoStationPosition();

    /**
     * Get the set of lettuce Station {@link Position}.
     * 
     * @return set of {@link Position}
     */

    Set<Position> getLettuceStationPosition();

    /**
     * Get the set of plate station {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getPlateStationPosition();

    /**
     * Get the set of trashcan {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getTrashcanPosition();

    /**
     * Get the set of washbin {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getWashbasinPosition();

    /**
     * Get the set of parquet floor {@link Position}.
     * 
     * @return set of {@link Position}
     */
    Set<Position> getParquetFloorPosition();

}
