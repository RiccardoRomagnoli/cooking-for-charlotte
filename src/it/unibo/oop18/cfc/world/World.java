package it.unibo.oop18.cfc.world;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.manager.SpriteManager;
import it.unibo.oop18.cfc.manager.TileManager;
import it.unibo.oop18.cfc.object.GameObject;
import it.unibo.oop18.cfc.object.Entity.PlayerImpl;
import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
import it.unibo.oop18.cfc.object.Stations.AbstractStationObject;
import it.unibo.oop18.cfc.object.Stations.BreadStation;
import it.unibo.oop18.cfc.object.Stations.ChoppingStation;
import it.unibo.oop18.cfc.object.Stations.Cooker;
import it.unibo.oop18.cfc.object.Stations.Counter;
import it.unibo.oop18.cfc.object.Stations.DeliveryStation;
import it.unibo.oop18.cfc.object.Stations.LettuceStation;
import it.unibo.oop18.cfc.object.Stations.MeatStation;
import it.unibo.oop18.cfc.object.Stations.PlateStation;
import it.unibo.oop18.cfc.object.Stations.TomatoStation;
import it.unibo.oop18.cfc.object.Stations.Trashcan;
import it.unibo.oop18.cfc.object.Stations.Washbasin;
import it.unibo.oop18.cfc.orders.OrdersManager;
import it.unibo.oop18.cfc.util.GameTimer;

/**
 * This interface declares the methods of a world.
 */
public interface World {

    /**
     * Updates world's state.
     * 
     */
    void update();

    /**
     * Renders all object' sprite.
     * @param g the graphic element
     */
    void draw(Graphics2D g);

    /**
     * Does the process input of any alive object.
     */
    void processInput();

    /**
     * Get all game object from the world.
     * 
     * @return all games object
     */
    List<? extends GameObject> getAllGameObjects();

    /**
     * Get all station object from the world.
     * 
     * @return all games object
     */
    List<? extends AbstractStationObject> getAllStations();

    /**
     * Removes a game object from the world.
     * 
     * @param object the object to remove
     * @param <X>    object's type to remove
     */
    <X extends GameObject> void removeObject(X object);

    /**
     * Gets the tilemanager.
     * 
     * @return the player
     */
    TileManager getTileManager();

    /**
     * Gets the spritemanager.
     * 
     * @return the player
     */
    SpriteManager getSpriteManager();

    /**
     * Gets the itemanager.
     * 
     * @return the player
     */
    ItemManager getItemManager();

    /**
     * Gets the ordermanager.
     * 
     * @return the player
     */
    OrdersManager getOrdersManager();
    
    /**
     * Gets the player.
     * 
     * @return the player
     */
    PlayerImpl getPlayer();

    /**
     * Gets the game timer.
     * 
     * @return world's timer
     */
    GameTimer getGameTimer();

    /**
     * Gets the Chopping Stations object.
     * 
     * @return all this stations
     */
    Set<ChoppingStation> getChoppingStations();

    /**
     * Gets the Cooker Stations object.
     * 
     * @return all this stations
     */

    Set<Cooker> getCookers();

    /**
     * Gets the Counters Stations object.
     * 
     * @return all this stations
     */

    Set<Counter> getCounters();

    /**
     * Gets the Delivery Stations object.
     * 
     * @return all this stations
     */

    Set<DeliveryStation> getDeliveryStations();

    /**
     * Gets the Food Stations object.
     * 
     * @return all this stations
     */

    Set<BreadStation> getBreadStations();

    /**
     * Gets the Food Stations object.
     * 
     * @return all this stations
     */

    Set<MeatStation> getMeatStations();

    /**
     * Gets the Food Stations object.
     * 
     * @return all this stations
     */

    Set<TomatoStation> getTomatoStations();

    /**
     * Gets the Food Stations object.
     * 
     * @return all this stations
     */

    Set<LettuceStation> getLettuceStations();

    /**
     * Gets the Plate Stations object.
     * 
     * @return all this stations
     */

    Set<PlateStation> getPlateStations();

    /**
     * Gets the TrashCans Stations object.
     * 
     * @return all this stations
     */
    Set<Trashcan> getTrashcans();

    /**
     * Gets the WashBasin Stations object.
     * 
     * @return all this stations
     */
    Set<Washbasin> getWashbasins();

    /**
     * Gets the WashBasin Stations object.
     * 
     * @return all this stations
     */
    Set<ParquetFloor> getParquetFloor();
}