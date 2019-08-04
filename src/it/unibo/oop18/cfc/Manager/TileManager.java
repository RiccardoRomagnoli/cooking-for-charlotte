package it.unibo.oop18.cfc.Manager;

import java.io.IOException;

import it.unibo.oop18.cfc.Tile.ChoppingStationTile;
import it.unibo.oop18.cfc.Tile.CookerTile;
import it.unibo.oop18.cfc.Tile.CounterTile;
import it.unibo.oop18.cfc.Tile.DeliveryStationTile;
import it.unibo.oop18.cfc.Tile.FoodStationTile;
import it.unibo.oop18.cfc.Tile.ParquetFloorTile;
import it.unibo.oop18.cfc.Tile.PlateStationTile;
import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Tile.TrashcanTile;
import it.unibo.oop18.cfc.Tile.WashbasinTile;





/**
 * This class stores and gets any kind of sprite in game.
 */
public class TileManager {

    private final ChoppingStationTile choppingStationTile;
    private final CookerTile cookerTile;
    private final CounterTile counterTile;
    private final DeliveryStationTile deliveryStationTile;
    private final FoodStationTile foodStationTile;
    private final PlateStationTile plateStationTile;
    private final TrashcanTile trashcanTile;
    private final WashbasinTile washbasinTile;
    private final ParquetFloorTile parquetFloorTile;
    /**
     * Creates a {@code SpritesManager} to manage any {@link Sprite} in game.
     *
     * @param path path
     * @throws IOException : problem during input/output
     */
    public TileManager(final String path) throws IOException {
        final TileSheet sheet = new TileSheet(path);
        this.choppingStationTile = new ChoppingStationTile(sheet);
        this.cookerTile = new CookerTile(sheet);
        this.counterTile = new CounterTile(sheet);
        this.deliveryStationTile = new DeliveryStationTile(sheet);
        this.foodStationTile = new FoodStationTile(sheet);
        this.plateStationTile = new PlateStationTile(sheet);
        this.trashcanTile = new TrashcanTile(sheet);
        this.washbasinTile = new WashbasinTile(sheet);
        this.parquetFloorTile = new ParquetFloorTile(sheet);
    }
    /**
     * @return the choppingStationTile
     */
    public ChoppingStationTile getChoppingStationTile() {
        return choppingStationTile;
    }
    /**
     * @return the cookerTile
     */
    public CookerTile getCookerTile() {
        return cookerTile;
    }
    /**
     * @return the counterTile
     */
    public CounterTile getCounterTile() {
        return counterTile;
    }
    /**
     * @return the deliveryStationTile
     */
    public DeliveryStationTile getDeliveryStationTile() {
        return deliveryStationTile;
    }
    /**
     * @return the foodStationTile
     */
    public FoodStationTile getFoodStationTile() {
        return foodStationTile;
    }
    /**
     * @return the plateStationTile
     */
    public PlateStationTile getPlateStationTile() {
        return plateStationTile;
    }
    /**
     * @return the trashcanTile
     */
    public TrashcanTile getTrashcanTile() {
        return trashcanTile;
    }
    /**
     * @return the washbasinTile
     */
    public WashbasinTile getWashbasinTile() {
        return washbasinTile;
    }
    /**
     * @return the washbasinTile
     */
    public ParquetFloorTile getParquetFloorTile() {
        return parquetFloorTile;
    }
}
