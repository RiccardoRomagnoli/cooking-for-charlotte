package it.unibo.oop18.cfc.World;

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
import it.unibo.oop18.cfc.Util.Position;

/**
 * This class models {@link GameObjectFactory}.
 */
public class GameObjectFactoryImpl implements GameObjectFactory {

    private SpriteManager sm;
    private TileManager tm;
    /**
     * Creates a {@code GameObjectFactoryImpl}.
     * @param tm tilemanager
     */
    public GameObjectFactoryImpl(final TileManager tm, final SpriteManager sm) {
        this.tm = tm;
        this.sm = sm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerImpl createPlayer(final Position position, final World world) {
        return new PlayerImpl(new Position(position), this.sm.getPlayerSprites(), world);
    }

    @Override
    public ChoppingStation createChoppingBoard(final Position position) {
        return new ChoppingStation(new Position(position), this.tm.getChoppingStationTile());
    }

    @Override
    public Cooker createCooker(final Position position) {
        return new Cooker(new Position(position), this.tm.getCookerTile());
    }

    @Override
    public Counter createCounter(final Position position) {
        return new Counter(new Position(position), this.tm.getCounterTile());
    }

    @Override
    public DeliveryStation createDeliveryStation(final Position position) {
        return new DeliveryStation(new Position(position), this.tm.getDeliveryStationTile());
    }

    @Override
    public FoodStation createFoodStation(final Position position) {
        return new FoodStation(new Position(position), this.tm.getFoodStationTile());
    }

    @Override
    public Trashcan createTrashcan(final Position position) {
        return new Trashcan(new Position(position), this.tm.getTrashcanTile());
    }

    @Override
    public Washbasin createWashbasin(final Position position) {
        return new Washbasin(new Position(position), this.tm.getWashbasinTile());
    }

    @Override
    public PlateStation createPlateStation(final Position position) {
        return new PlateStation(new Position(position), this.tm.getPlateStationTile());
    }

    @Override
    public ParquetFloor createParquetFloor(final Position position, final boolean leftFloor) {
        return new ParquetFloor(new Position(position), this.tm.getParquetFloorTile(), leftFloor);
    }

}
