package it.unibo.oop18.cfc.World;

import it.unibo.oop18.cfc.Manager.TileManager;
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

    //private SpriteManager sm;
    private TileManager tm;
    /**
     * Creates a {@code GameObjectFactoryImpl}.
     * 
     */
    public GameObjectFactoryImpl() {

    }

    /**
     * {@inheritDoc}
     */
//    @Override
//    public PlayerImpl createPlayer(final Position position, final World world) {
//        return new PlayerImpl(new Position(position), this.theme.getSprites().getPlayerSprite(), world);
//    }

    @Override
    public ChoppingStation createChoppingBoard(Position position) {
        return new ChoppingStation(new Position(position), this.tm.getChoppingStationTile());
    }

    @Override
    public Cooker createCooker(Position position) {
        return new Cooker(new Position(position), this.tm.getCookerTile());
    }

    @Override
    public Counter createCounter(Position position) {
        return new Counter(new Position(position), this.tm.getCounterTile());
    }

    @Override
    public DeliveryStation createDeliveryStation(Position position) {
        return new DeliveryStation(new Position(position), this.tm.getDeliveryStationTile());
    }

    @Override
    public FoodStation createFoodStation(Position position) {
        return new FoodStation(new Position(position), this.tm.getFoodStationTile());
    }

    @Override
    public Trashcan createTrashcan(Position position) {
        return new Trashcan(new Position(position), this.tm.getTrashcanTile());
    }

    @Override
    public Washbasin createWashbasin(Position position) {
        return new Washbasin(new Position(position), this.tm.getWashbasinTile());
    }

    @Override
    public PlateStation createPlateStation(Position position) {
        return new PlateStation(new Position(position), this.tm.getPlateStationTile());
    }

}
