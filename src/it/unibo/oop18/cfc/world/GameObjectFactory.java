package it.unibo.oop18.cfc.world;

import it.unibo.oop18.cfc.object.entity.PlayerImpl;
import it.unibo.oop18.cfc.object.floors.ParquetFloor;
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
import it.unibo.oop18.cfc.util.Position;

/**
 * This interface declares the method of a {@link GameObjectFactory}.
 */
public interface GameObjectFactory {

    /**
     * Creates a new {@link PlayerImpl}.
     *
     * @param position the {@link Position}
     * @param world    the {@link World}
     * @return the {@link PlayerImpl}
     */
    PlayerImpl createPlayer(Position position, World world);

    /**
     * Creates a new {@link ChoppingStation}.
     *
     * @param position the {@link Position}
     * @param world    the {@link World}
     * @return the {@link ChoppingStation}
     */
    ChoppingStation createChoppingBoard(Position position, World world);

    /**
     * Creates a new {@link Cooker}.
     *
     * @param position the {@link Position}
     * @return the {@link Cooker}
     */
    Cooker createCooker(Position position);

    /**
     * Creates a new {@link Counter}.
     *
     * @param position the {@link Position}
     * @return the {@link Counter}
     */
    Counter createCounter(Position position);

    /**
     * Creates a new {@link DeliveryStation}.
     *
     * @param position the {@link Position}
     * @return the {@link DeliveryStation}
     */
    DeliveryStation createDeliveryStation(Position position);

    /**
     * Creates a new {@link PlateStation}.
     *
     * @param position the {@link Position}
     * @return the {@link PlateStation}
     */
    PlateStation createPlateStation(Position position);

    /**
     * Creates a new {@link BreadStation}.
     *
     * @param position the {@link Position}
     * @return the {@link BreadStation}
     */
    BreadStation createBreadStation(Position position);

    /**
     * Creates a new {@link MeatStation}.
     *
     * @param position the {@link Position}
     * @return the {@link MeatStation}
     */
    MeatStation createMeatStation(Position position);

    /**
     * Creates a new {@link LettuceStation}.
     *
     * @param position the {@link Position}
     * @return the {@link LettuceStation}
     */
    LettuceStation createLettuceStation(Position position);

    /**
     * Creates a new {@link TomatoStation}.
     *
     * @param position the {@link Position}
     * @return the {@link TomatoStation}
     */
    TomatoStation createTomatoStation(Position position);

    /**
     * Creates a new {@link Trashcan}.
     *
     * @param position the {@link Position}
     * @return the {@link Trashcan}
     */
    Trashcan createTrashcan(Position position);

    /**
     * Creates a new {@link Washbasin}.
     *
     * @param position the {@link Position}
     * @return the {@link Washbasin}
     */
    Washbasin createWashbasin(Position position);

    /**
     * Creates a new {@link ParquetFloor}.
     *
     * @param position    the {@link Position}
     * @param leftParquet the left parquet
     * @return the {@link ParquetFloor}
     */
    ParquetFloor createParquetFloor(Position position);

}
