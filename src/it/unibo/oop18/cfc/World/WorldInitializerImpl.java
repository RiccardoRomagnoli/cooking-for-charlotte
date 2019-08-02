package it.unibo.oop18.cfc.World;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.FoodStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Objects.Stations.Washbasin;
import it.unibo.oop18.cfc.TileMap.TileMapImpl;

/**
 * This class models {@link WorldInitializer}.
 */
public class WorldInitializerImpl implements WorldInitializer {

    private final GameObjectFactory factory;
    private TileMapImpl tilemap;

    public WorldInitializerImpl() {
        this.factory = new GameObjectFactoryImpl();
        this.tilemap = new TileMapImpl("testmap1.map");
    }

    @Override
    public Set<ChoppingStation> initializeChoppingBoard() {
        return this.tilemap.getChoppingStationPosition().stream()
                .map(p -> this.factory.createChoppingBoard(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<Cooker> initializeCooker() {
        return this.tilemap.getCookerPosition().stream()
                .map(p -> this.factory.createCooker(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<Counter> initializeCounter() {
        return this.tilemap.getCounterPosition().stream()
                .map(p -> this.factory.createCounter(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<DeliveryStation> initializeDeliveryStation() {
        return this.tilemap.getDeliveryStationPosition().stream()
                .map(p -> this.factory.createDeliveryStation(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<FoodStation> initializeFoodStation() {
        return this.tilemap.getFoodStationPosition().stream()
                .map(p -> this.factory.createFoodStation(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<Trashcan> initializeTrashcan() {
        return this.tilemap.getTrashcanPosition().stream()
                .map(p -> this.factory.createTrashcan(p))
                .collect(Collectors.toSet());
    }



    @Override
    public Set<Washbasin> initializeWashbasin() {
        return this.tilemap.getWashbasinPosition().stream()
                .map(p -> this.factory.createWashbasin(p))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<PlateStation> initializePlateStation() {
        return this.tilemap.getPlateStationPosition().stream()
                .map(p -> this.factory.createPlateStation(p))
                .collect(Collectors.toSet());
    }
    
    

//    @Override
//    public PlayerImpl initializePlayer(World world) {
//        return this.tilemap.getChoppingStationPosition().stream()
//                .map(p -> this.factory.createChoppingBoard(p))
//                .collect(Collectors.toSet());
//    }




}
