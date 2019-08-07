package it.unibo.oop18.cfc.World;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Manager.SpriteManager;
import it.unibo.oop18.cfc.Manager.TileManager;
import it.unibo.oop18.cfc.Objects.GameObject;
import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Floors.ParquetFloor;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Objects.Stations.AbstractStationObject;
import it.unibo.oop18.cfc.Objects.Stations.BreadStation;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.LettuceStation;
import it.unibo.oop18.cfc.Objects.Stations.MeatStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Objects.Stations.TomatoStation;
import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Objects.Stations.Washbasin;
import it.unibo.oop18.cfc.Util.GameTimer;

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
     * Renders all objects' sprite.
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
     * @return all games objects
     */
    List<? extends GameObject> getAllGameObjects();

    /**
     * Get all station object from the world.
     * 
     * @return all games objects
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
     * Removes a game object from the world.
     * 
     * @param item the item to remove
     * @param <X>    object's type to remove
     */
    <X extends Item> void removeItem(X item);

    /**
     * Add and ingredient or a plate.
     * 
     * @param item item to add
     */
    void addItem(Item item);

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
     * Gets the Chopping Stations objects.
     * 
     * @return all this stations
     */
    Set<ChoppingStation> getChoppingStations();

    /**
     * Gets the Cooker Stations objects.
     * 
     * @return all this stations
     */

    Set<Cooker> getCookers();

    /**
     * Gets the Counters Stations objects.
     * 
     * @return all this stations
     */

    Set<Counter> getCounters();

    /**
     * Gets the Delivery Stations objects.
     * 
     * @return all this stations
     */

    Set<DeliveryStation> getDeliveryStations();

    /**
     * Gets the Food Stations objects.
     * 
     * @return all this stations
     */

    Set<BreadStation> getBreadStations();

    /**
     * Gets the Food Stations objects.
     * 
     * @return all this stations
     */

    Set<MeatStation> getMeatStations();

    /**
     * Gets the Food Stations objects.
     * 
     * @return all this stations
     */

    Set<TomatoStation> getTomatoStations();

    /**
     * Gets the Food Stations objects.
     * 
     * @return all this stations
     */

    Set<LettuceStation> getLettuceStations();

    /**
     * Gets the Plate Stations objects.
     * 
     * @return all this stations
     */

    Set<PlateStation> getPlateStations();

    /**
     * Gets the TrashCans Stations objects.
     * 
     * @return all this stations
     */
    Set<Trashcan> getTrashcans();

    /**
     * Gets the WashBasin Stations objects.
     * 
     * @return all this stations
     */
    Set<Washbasin> getWashbasins();

    /**
     * Gets the WashBasin Stations objects.
     * 
     * @return all this stations
     */
    Set<ParquetFloor> getParquetFloor();
}
