package it.unibo.oop18.cfc.world;

import it.unibo.oop18.cfc.manager.SpriteManager;
import it.unibo.oop18.cfc.manager.TileManager;
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
 * This class models {@link GameObjectFactory}.
 */
public class GameObjectFactoryImpl implements GameObjectFactory {

    private final SpriteManager sm;
    private final TileManager tm;

    /**
     * Instantiates a new game object factory impl.
     *
     * @param tm the {@link TileManager}
     * @param sm the {@link SpriteManager}
     */
    public GameObjectFactoryImpl(final TileManager tm, final SpriteManager sm) {
        this.tm = tm;
        this.sm = sm;
    }

    /**
     * {@inheritDoc}
     */
    public PlayerImpl createPlayer(final Position position, final World world) {
        return new PlayerImpl(new Position(position), this.sm.getPlayerSprites(), world);
    }

    /**
     * {@inheritDoc}
     */
    public ChoppingStation createChoppingBoard(final Position position, final World world) {
        return new ChoppingStation(new Position(position), this.tm.getChoppingStationTile(), world);
    }

    /**
     * {@inheritDoc}
     */
    public Cooker createCooker(final Position position) {
        return new Cooker(new Position(position), this.tm.getCookerTile());
    }

    /**
     * {@inheritDoc}
     */
    public Counter createCounter(final Position position) {
        return new Counter(new Position(position), this.tm.getCounterTile());
    }

    /**
     * {@inheritDoc}
     */
    public DeliveryStation createDeliveryStation(final Position position) {
        return new DeliveryStation(new Position(position), this.tm.getDeliveryStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public BreadStation createBreadStation(final Position position) {
        return new BreadStation(new Position(position), this.tm.getBreadStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public MeatStation createMeatStation(final Position position) {
        return new MeatStation(new Position(position), this.tm.getMeatStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public TomatoStation createTomatoStation(final Position position) {
        return new TomatoStation(new Position(position), this.tm.getTomatoStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public LettuceStation createLettuceStation(final Position position) {
        return new LettuceStation(new Position(position), this.tm.getLettuceStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public Trashcan createTrashcan(final Position position) {
        return new Trashcan(new Position(position), this.tm.getTrashcanTile());
    }

    /**
     * {@inheritDoc}
     */
    public Washbasin createWashbasin(final Position position) {
        return new Washbasin(new Position(position), this.tm.getWashbasinTile());
    }

    /**
     * {@inheritDoc}
     */
    public PlateStation createPlateStation(final Position position) {
        return new PlateStation(new Position(position), this.tm.getPlateStationTile());
    }

    /**
     * {@inheritDoc}
     */
    public ParquetFloor createParquetFloor(final Position position) {
        return new ParquetFloor(new Position(position), this.tm.getParquetFloorTile());
    }

}
