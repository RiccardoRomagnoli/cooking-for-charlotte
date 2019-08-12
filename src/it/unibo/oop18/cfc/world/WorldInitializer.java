package it.unibo.oop18.cfc.world;

import java.util.Set;

import it.unibo.oop18.cfc.object.entity.Player;
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

/**
 * This interface declares the method of a {@link WorldInitializer}.
 */
public interface WorldInitializer {

    /**
     * Initialize {@link ChoppingStation}.
     *
     * @param world the {@link World}
     * @return the sets of {@link ChoppingStation}
     */
    Set<ChoppingStation> initializeChoppingBoard(World world);

    /**
     * Initialize {@link Cooker}.
     *
     * @return the sets of {@link Cooker}
     */
    Set<Cooker> initializeCooker();

    /**
     * Initialize {@link Counter}.
     *
     * @return the sets of {@link Counter}
     */
    Set<Counter> initializeCounter();

    /**
     * Initialize {@link DeliveryStation}.
     *
     * @return the sets of {@link DeliveryStation}
     */
    Set<DeliveryStation> initializeDeliveryStation();

    /**
     * Initialize {@link BreadStation}.
     *
     * @return the sets of {@link BreadStation}
     */
    Set<BreadStation> initializeBreadStation();

    /**
     * Initialize {@link MeatStation}.
     *
     * @return the sets of {@link MeatStation}
     */
    Set<MeatStation> initializeMeatStation();

    /**
     * Initialize {@link TomatoStation}.
     *
     * @return the sets of {@link TomatoStation}
     */
    Set<TomatoStation> initializeTomatoStation();

    /**
     * Initialize {@link LettuceStation}.
     *
     * @return the sets of {@link LettuceStation}
     */
    Set<LettuceStation> initializeLettuceStation();

    /**
     * Initialize {@link Trashcan}.
     *
     * @return the sets of {@link Trashcan}
     */
    Set<Trashcan> initializeTrashcan();

    /**
     * Initialize {@link Washbasin}.
     *
     * @return the sets of {@link Washbasin}
     */
    Set<Washbasin> initializeWashbasin();

    /**
     * Initialize {@link PlateStation}.
     *
     * @return the sets of {@link PlateStation}
     */
    Set<PlateStation> initializePlateStation();

    /**
     * Initialize {@link ParquetFloor}.
     *
     * @return the sets of {@link ParquetFloor}
     */
    Set<ParquetFloor> initializeParquetFloor();

    /**
     * Initialize {@link Player}.
     *
     * @param world the {@link World}
     * @return the {@link Player}
     */
    PlayerImpl initializePlayer(World world);
}
