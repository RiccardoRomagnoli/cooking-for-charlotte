package it.unibo.oop18.cfc.World;

import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Floors.ParquetFloor;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Objects.Stations.Washbasin;
import it.unibo.oop18.cfc.Util.Position;

/**
 * This interface declares the method of a GameObjectFactory.
 */
public interface GameObjectFactory {

    /**
     * Creates a {@link PlayerImpl}.
     * 
     * @param position player's position.
     * @param world    the world where to add the player
     * @return a new player
     */
    PlayerImpl createPlayer(Position position, World world);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    ChoppingStation createChoppingBoard(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    Cooker createCooker(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    Counter createCounter(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    DeliveryStation createDeliveryStation(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    PlateStation createPlateStation(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    FoodStation createFoodStation(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    Trashcan createTrashcan(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    Washbasin createWashbasin(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    ParquetFloor createParquetFloor(Position position, boolean leftParquet);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    // Floor createFloor(Position position);

}
