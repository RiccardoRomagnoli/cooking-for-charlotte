package it.unibo.oop18.cfc.world;

import java.util.Set;

import it.unibo.oop18.cfc.object.Entity.PlayerImpl;
import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
import it.unibo.oop18.cfc.object.stations.BreadStation;
import it.unibo.oop18.cfc.object.stations.ChoppingStation;
import it.unibo.oop18.cfc.object.stations.Cooker;
import it.unibo.oop18.cfc.object.stations.Counter;
import it.unibo.oop18.cfc.object.stations.DeliveryStation;
import it.unibo.oop18.cfc.object.stations.LettuceStation;
import it.unibo.oop18.cfc.object.stations.MeatStation;
import it.unibo.oop18.cfc.object.stations.PlateStation;
import it.unibo.oop18.cfc.object.stations.TomatoStation;
import it.unibo.oop18.cfc.object.stations.Trashcan;
import it.unibo.oop18.cfc.object.stations.Washbasin;

/**
 * This interface declares a world initializer.
 */
public interface WorldInitializer {

    /**
     * Initializes all unbreakable blocks.
     * 
     * @return a set of unbreakable blocks
     */
    Set<ChoppingStation> initializeChoppingBoard(World world);

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
    Set<BreadStation> initializeBreadStation();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<MeatStation> initializeMeatStation();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<TomatoStation> initializeTomatoStation();

    /**
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<LettuceStation> initializeLettuceStation();
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
     * Initializes initial free tiles.
     * 
     * @return free tiles
     */
    Set<ParquetFloor> initializeParquetFloor();

    /**
     * Initializes the player.
     * 
     * @param world where to add the player
     * @return the player
     */
    PlayerImpl initializePlayer(World world); 
}
