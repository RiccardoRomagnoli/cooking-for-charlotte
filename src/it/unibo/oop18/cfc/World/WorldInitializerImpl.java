package it.unibo.oop18.cfc.World;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.Manager.SpriteManager;
import it.unibo.oop18.cfc.Manager.TileManager;
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
import it.unibo.oop18.cfc.Sprite.SpriteSheet;
import it.unibo.oop18.cfc.TileMap.TileMapImpl;
import it.unibo.oop18.cfc.Util.Position;

/**
 * This class models {@link WorldInitializer}.
 */
public class WorldInitializerImpl implements WorldInitializer {

    private static final int START_PLAYER_X = 7;
    private static final int START_PLAYER_Y = 7;
    private final GameObjectFactory factory;
    private TileMapImpl tilemap;

    public WorldInitializerImpl(TileManager tm, SpriteManager sm, String mapPath) {
        this.factory = new GameObjectFactoryImpl(tm, sm);
        this.tilemap = new TileMapImpl(mapPath);
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

    @Override
    public Set<ParquetFloor> initializeParquetFloor() {
        return this.tilemap.getParquetFloorPosition().stream()
                .map(p -> this.factory.createParquetFloor(p, p.getX() / 64 % 2 == 0 ? true : false))
                .collect(Collectors.toSet());
    }

    @Override
    public PlayerImpl initializePlayer(World world) {
        return this.factory.createPlayer(new Position(START_PLAYER_X * SpriteSheet.SPRITE_SIZE_IN_GAME,
                START_PLAYER_Y * SpriteSheet.SPRITE_SIZE_IN_GAME), world);

    }




}
