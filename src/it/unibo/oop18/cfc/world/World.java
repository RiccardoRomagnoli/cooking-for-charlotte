package it.unibo.oop18.cfc.world;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.manager.SpriteManager;
import it.unibo.oop18.cfc.manager.TileManager;
import it.unibo.oop18.cfc.object.GameObject;
import it.unibo.oop18.cfc.object.entity.Player;
import it.unibo.oop18.cfc.object.floors.ParquetFloor;
import it.unibo.oop18.cfc.object.stations.AbstractStationObject;
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
import it.unibo.oop18.cfc.orders.OrdersManager;
import it.unibo.oop18.cfc.util.GameTimer;

/**
 * This interface declares a set of methods of a world.
 */
public interface World {

    /**
     * Updates world's state.
     * 
     */
    void update();

    /**
     * Renders all object sprite and tile.
     * 
     * @param g a set of graphic element
     */
    void draw(Graphics2D g);

    /**
     * Get all game object from a set of world.
     * 
     * @return all games object
     */
    List<? extends GameObject> getAllGameObjects();

    /**
     * Get all station object from a set of world.
     * 
     * @return all games object
     */
    List<? extends AbstractStationObject> getAllStations();

    /**
     * Removes a game object from a set of world's objects.
     * 
     * @param object a set of object to remove
     * @param <X>    object's type to remove
     */
    <X extends GameObject> void removeObject(X object);

    /**
     * Gets the {@link TileManager}.
     * 
     * @return the {@link TileManager}
     */
    TileManager getTileManager();

    /**
     * Gets the {@link SpriteManager}.
     * 
     * @return the {@link SpriteManager}
     */
    SpriteManager getSpriteManager();

    /**
     * Gets the {@link ItemManager}.
     * 
     * @return the {@link ItemManager}
     */
    ItemManager getItemManager();

    /**
     * Gets the {@link OrdersManager}.
     * 
     * @return the {@link OrdersManager}
     */
    OrdersManager getOrdersManager();

    /**
     * Gets the {@link Player}.
     * 
     * @return the {@link Player}
     */
    Player getPlayer();

    /**
     * Gets the {@link GameTimer}.
     * 
     * @return world's {@link GameTimer}
     */
    GameTimer getGameTimer();

    /**
     * Gets a set of {@link ChoppingStation}.
     * 
     * @return all this {@link ChoppingStation}
     */
    Set<ChoppingStation> getChoppingStations();

    /**
     * Gets a set of {@link Cooker}.
     * 
     * @return all this {@link Cooker}
     */

    Set<Cooker> getCookers();

    /**
     * Gets a set of {@link Counter}.
     * 
     * @return all this {@link Counter}
     */

    Set<Counter> getCounters();

    /**
     * Gets a set of {@link DeliveryStation}.
     * 
     * @return all this {@link DeliveryStation}
     */

    Set<DeliveryStation> getDeliveryStations();

    /**
     * Gets a set of {@link BreadStation}.
     * 
     * @return all this {@link BreadStation}
     */

    Set<BreadStation> getBreadStations();

    /**
     * Gets a set of {@link MeatStation}.
     * 
     * @return all this {@link MeatStation}
     */

    Set<MeatStation> getMeatStations();

    /**
     * Gets a set of {@link TomatoStation}.
     * 
     * @return all this {@link TomatoStation}
     */

    Set<TomatoStation> getTomatoStations();

    /**
     * Gets a set of {@link LettuceStation}.
     * 
     * @return all this {@link LettuceStation}
     */

    Set<LettuceStation> getLettuceStations();

    /**
     * Gets a set of {@link PlateStation}.
     * 
     * @return all this {@link PlateStation}
     */

    Set<PlateStation> getPlateStations();

    /**
     * Gets a set of {@link Trashcan}.
     * 
     * @return all this {@link Trashcan}
     */
    Set<Trashcan> getTrashcans();

    /**
     * Gets a set of {@link Washbasin}.
     * 
     * @return all this {@link Washbasin}
     */
    Set<Washbasin> getWashbasins();

    /**
     * Gets a set of {@link ParquetFloor}.
     * 
     * @return all this {@link ParquetFloor}
     */
    Set<ParquetFloor> getParquetFloor();
}