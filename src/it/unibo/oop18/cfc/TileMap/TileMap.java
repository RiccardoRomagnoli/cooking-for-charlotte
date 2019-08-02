package it.unibo.oop18.cfc.TileMap;

import java.util.Set;

import it.unibo.oop18.cfc.Util.Position;

public interface TileMap {

    /**
     * Load the map of the game based of the bitmap.
     * 
     * @param s The name of the file with the bitmap
     */
    public void loadMap();
    
    public Set<Position> getChoppingStationPosition();
    
    public Set<Position> getCookerPosition();
    
    public Set<Position> getCounterPosition();
    
    public Set<Position> getDeliveryStationPosition();
    
    public Set<Position> getFoodStationPosition();
    
    public Set<Position> getPlateStationPosition();
    
    public Set<Position> getTrashcanPosition();
    
    public Set<Position> getWashbasinPosition();
}
