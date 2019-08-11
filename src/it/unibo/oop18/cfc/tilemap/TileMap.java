package it.unibo.oop18.cfc.tilemap;

import java.util.Set;

import it.unibo.oop18.cfc.util.Position;

interface TileMap {

    /**
     * Load the map of the game based of the bitmap.
     * 
     * @param s The name of the file with the bitmap
     */
    void loadMap();

    /**
     * Get the set of chopping station position.
     * 
     * @return set of position
     */
    Set<Position> getChoppingStationPosition();

    /**
     * Get the set of cooker station position.
     * 
     * @return set of position
     */
    Set<Position> getCookerPosition();

    /**
     * Get the set of counter Position.
     * 
     * @return set of position
     */
    Set<Position> getCounterPosition();

    /**
     * Get the set of delivery Position.
     * 
     * @return set of position
     */
    Set<Position> getDeliveryStationPosition();

    /**
     * Get the set of food Station Position.
     * 
     * @return set of position
     */
    Set<Position> getBreadStationPosition();

    /**
     * Get the set of food Station Position.
     * 
     * @return set of position
     */
    Set<Position> getMeatStationPosition();

    /**
     * Get the set of food Station Position.
     * 
     * @return set of position
     */
    Set<Position> getTomatoStationPosition();

    /**
     * Get the set of food Station Position.
     * 
     * @return set of position
     */

    Set<Position> getLettuceStationPosition();
    /**
     * Get the set of plate Position.
     * 
     * @return set of position
     */
    Set<Position> getPlateStationPosition();

    /**
     * Get the set of trash can Position.
     * 
     * @return set of position
     */
    Set<Position> getTrashcanPosition();

    /**
     * Get the set of wash bin Position.
     * 
     * @return set of position
     */
    Set<Position> getWashbasinPosition();

    /**
     * Get the set of wash bin Position.
     * 
     * @return set of position
     */
    Set<Position> getParquetFloorPosition(); 

}
