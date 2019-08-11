package it.unibo.oop18.cfc.world;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.manager.SpriteManager;
import it.unibo.oop18.cfc.manager.TileManager;
import it.unibo.oop18.cfc.object.Entity.PlayerImpl;
import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
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
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.tilemap.TileMapImpl;
import it.unibo.oop18.cfc.util.Position;

/**
 * This class models {@link WorldInitializer}.
 */
public class WorldInitializerImpl implements WorldInitializer {

    private static final int START_PLAYER_X = 7;
    private static final int START_PLAYER_Y = 7;
    private final GameObjectFactory factory;
    private final TileMapImpl tilemap;

    public WorldInitializerImpl(final TileManager tm, final SpriteManager sm, final ItemManager im, final String mapPath) {
        this.factory = new GameObjectFactoryImpl(tm, sm, im);
        this.tilemap = new TileMapImpl(mapPath);
    }

    @Override
    public Set<ChoppingStation> initializeChoppingBoard(final World world) {
        return this.tilemap.getChoppingStationPosition().stream()
                .map(p -> this.factory.createChoppingBoard(p, world))
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
