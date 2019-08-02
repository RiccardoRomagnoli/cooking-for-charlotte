package it.unibo.oop18.cfc.World;

import java.util.Set;

import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Objects.Stations.Washbasin;

/**
 * This interface declares a world initializer.
 */
public interface WorldInitializer {

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    // Set<Floor> initializeFloor();

    /**
     * Initializes all unbreakable blocks.
     * 
     * @return a set of unbreakable blocks
     */
    Set<ChoppingStation> initializeChoppingBoard();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<Cooker> initializeCooker();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<Counter> initializeCounter();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<DeliveryStation> initializeDeliveryStation();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<FoodStation> initializeFoodStation();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<Trashcan> initializeTrashcan();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<Washbasin> initializeWashbasin();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<PlateStation> initializePlateStation();

    /**
     * Initializes the player.
     * 
     * @param world where to add the player
     * @return the player
     */
    //PlayerImpl initializePlayer(World world); 
}