package it.unibo.oop18.cfc.world;

import java.util.Set;

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
 * The Interface WorldInitializer.
 */
public interface WorldInitializer {

    /**
     * Initialize chopping board.
     *
     * @param world the {@link World}
     * @return the sets of {@link ChoppingStation}
     */
    Set<ChoppingStation> initializeChoppingBoard(World world);

    /**
     * Initialize cooker.
     *
     * @return the sets of {@link Cooker}
     */
    Set<Cooker> initializeCooker();

    /**
     * Initialize counter.
     *
     * @return the sets of {@link Counter}
     */
    Set<Counter> initializeCounter();

    /**
     * Initialize delivery station.
     *
     * @return the sets of {@link DeliveryStation}
     */
    Set<DeliveryStation> initializeDeliveryStation();

    /**
     * Initialize bread station.
     *
     * @return the sets of {@link BreadStation}
     */
    Set<BreadStation> initializeBreadStation();

    /**
     * Initialize meat station.
     *
     * @return the sets of {@link MeatStation}
     */
    Set<MeatStation> initializeMeatStation();
    
    /**
     * Initialize tomato station.
     *
     * @return the sets of {@link TomatoStation}
     */
    Set<TomatoStation> initializeTomatoStation();

    /**
     * Initialize lettuce station.
     *
     * @return the sets of {@link LettuceStation}
     */
    Set<LettuceStation> initializeLettuceStation();

    /**
     * Initialize trashcan.
     *
     * @return the sets of {@link Trashcan}
     */
    Set<Trashcan> initializeTrashcan();

    /**
     * Initialize washbasin.
     *
     * @return the sets of {@link Washbasin}
     */
    Set<Washbasin> initializeWashbasin();

    /**
     * Initialize plate station.
     *
     * @return the sets of {@link PlateStation}
     */
    Set<PlateStation> initializePlateStation();

    /**
     * Initialize parquet floor.
     *
     * @return the sets of {@link ParquetFloor}
     */
    Set<ParquetFloor> initializeParquetFloor();

    /**
     * Initialize player.
     *
     * @param world the {@link World}
     * @return the player impl
     */
    PlayerImpl initializePlayer(World world); 
}
