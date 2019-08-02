package it.unibo.oop18.cfc.World;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.Objects.GameObject;
import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
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
     * Removes a game object from the world.
     * 
     * @param object the object to remove
     * @param <X>    object's type to remove
     */
    <X extends GameObject> void removeObject(X object);

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
     * Gets the game timer.
     * 
     * @return all this stations
     */
    Set<ChoppingStation> getChoppingStations();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */

    Set<Cooker> getCookers();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */

    Set<Counter> getCounters();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */

    Set<DeliveryStation> getDeliveryStations();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */

    Set<FoodStation> getFoodStations();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */

    Set<PlateStation> getPlateStations();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */
    Set<Trashcan> getTrashcans();

    /**
     * Gets the game timer.
     * 
     * @return all this stations
     */
    Set<Washbasin> getWashbasins();

}