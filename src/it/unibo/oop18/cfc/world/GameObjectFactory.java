package it.unibo.oop18.cfc.world;

import it.unibo.oop18.cfc.object.Entity.PlayerImpl;
import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
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
import it.unibo.oop18.cfc.util.Position;

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
    ChoppingStation createChoppingBoard(Position position, World world);

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
    BreadStation createBreadStation(Position position);

    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    MeatStation createMeatStation(Position position);
    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    LettuceStation createLettuceStation(Position position);
    /**
     * Creates an unbreakable {@link Block}.
     * 
     * @param position block's position
     * @return a new unbreakable Block
     */
    TomatoStation createTomatoStation(Position position);
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