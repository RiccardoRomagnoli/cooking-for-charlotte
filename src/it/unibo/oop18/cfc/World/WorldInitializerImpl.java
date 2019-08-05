package it.unibo.oop18.cfc.World;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.Manager.SpriteManager;
import it.unibo.oop18.cfc.Manager.TileManager;
import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Floors.ParquetFloor;
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
    private final TileMapImpl tilemap;

    public WorldInitializerImpl(final TileManager tm, final SpriteManager sm, final String mapPath) {
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
    public Set<BreadStation> initializeBreadStation() {
        return this.tilemap.getBreadStationPosition().stream()
                .map(p -> this.factory.createBreadStation(p))
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
    public PlayerImpl initializePlayer(final World world) {
        return this.factory.createPlayer(new Position(START_PLAYER_X * SpriteSheet.SPRITE_SIZE_IN_GAME,
                START_PLAYER_Y * SpriteSheet.SPRITE_SIZE_IN_GAME), world);

    }

    @Override
    public Set<MeatStation> initializeMeatStation() {
        return this.tilemap.getMeatStationPosition().stream()
                .map(p -> this.factory.createMeatStation(p))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<TomatoStation> initializeTomatoStation() {
        return this.tilemap.getTomatoStationPosition().stream()
                .map(p -> this.factory.createTomatoStation(p))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<LettuceStation> initializeLettuceStation() {
        return this.tilemap.getLettuceStationPosition().stream()
                .map(p -> this.factory.createLettuceStation(p))
                .collect(Collectors.toSet());
    }




}
