package it.unibo.oop18.cfc.World;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.Manager.SpriteManager;
import it.unibo.oop18.cfc.Manager.TileManager;
import it.unibo.oop18.cfc.Objects.GameObject;
import it.unibo.oop18.cfc.Objects.Entity.PlayerImpl;
import it.unibo.oop18.cfc.Objects.Floors.ParquetFloor;
import it.unibo.oop18.cfc.Objects.Items.Item;
import it.unibo.oop18.cfc.Objects.Stations.AbstractStationObject;
import it.unibo.oop18.cfc.Objects.Stations.BreadStation;
import it.unibo.oop18.cfc.Objects.Stations.ChoppingStation;
import it.unibo.oop18.cfc.Objects.Stations.Cooker;
import it.unibo.oop18.cfc.Objects.Stations.Counter;
import it.unibo.oop18.cfc.Objects.Stations.DeliveryStation;
import it.unibo.oop18.cfc.Objects.Stations.LettuceStation;
import it.unibo.oop18.cfc.Objects.Stations.MeatStation;
import it.unibo.oop18.cfc.Objects.Stations.PlateStation;
import it.unibo.oop18.cfc.Objects.Stations.Station;
import it.unibo.oop18.cfc.Objects.Stations.TomatoStation;
import it.unibo.oop18.cfc.Objects.Stations.Trashcan;
import it.unibo.oop18.cfc.Objects.Stations.Washbasin;
import it.unibo.oop18.cfc.Tile.TileSheet;
import it.unibo.oop18.cfc.Util.GameTimer;

/**
 * This class manages the whole game world.
 */
public class WorldImpl implements World {

    /**
     * The lower bound in the world.
     */
    public static final int LOWER_BOUND = 1;
    /**
     * The upper bound in the world.
     */
    public static final int UPPER_BOUND = 16;
    /**
     * The upper bound in pixel.
     */
    public static final int UPPER_BOUND_IN_PIXEL = (2 * TileSheet.TILE_SIZE_IN_GAME);
    /**
     * The lower bound in pixel.
     */
    public static final int LOWER_BOUND_IN_PIXEL = 0 + TileSheet.TILE_SIZE_IN_GAME;

    /**
     * Path to map.
     */
    public static final String MAPPATH = "/Maps/testmap1.map";

    /**
     * Path to tilesheet.
     */
    public static final String TILEPATH = "/Tilesets/tilesheet.png";
    /**
     * Path to player Sprite.
     */
    public static final String SPRITEPATH = "/Sprites/baker.png";

    private final Set<ChoppingStation> choppingStations;
    private final Set<Cooker> cookers;
    private final Set<Counter> counters;
    private final Set<DeliveryStation> deliveryStations;
    private final Set<BreadStation> breadStations;
    private final Set<MeatStation> meatStations;
    private final Set<TomatoStation> tomatoStations;
    private final Set<LettuceStation> lettuceStations;
    private final Set<PlateStation> plateStations;
    private final Set<Trashcan> trashcans;
    private final Set<Washbasin> washbasins;
    private final Set<ParquetFloor> parquetFloor;
    private final Set<Item> itemsInWorld;
    private PlayerImpl player;
    private final GameTimer timer;
    // private final PlayerScore score;

    /**
     * Creates a {@code WorldImpl}.
     * 
     * @throws IOException on tilemanager error
     *
     */
    public WorldImpl() throws IOException {
        this.choppingStations = new HashSet<>();
        this.counters = new HashSet<>();
        this.cookers = new HashSet<>();
        this.deliveryStations = new HashSet<>();
        this.breadStations = new HashSet<>();
        this.meatStations = new HashSet<>();
        this.tomatoStations = new HashSet<>();
        this.lettuceStations = new HashSet<>();
        this.plateStations = new HashSet<>();
        this.trashcans = new HashSet<>();
        this.washbasins = new HashSet<>();
        this.parquetFloor = new HashSet<>();
        this.createLevel(new TileManager(TILEPATH), new SpriteManager(SPRITEPATH), MAPPATH);
        this.timer = new GameTimer();
        this.itemsInWorld = new HashSet<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends GameObject> getAllGameObjects() {
        final List<GameObject> allGameObjects = new LinkedList<>();
        allGameObjects.addAll(this.choppingStations);
        allGameObjects.addAll(this.counters);
        allGameObjects.addAll(this.cookers);
        allGameObjects.addAll(this.deliveryStations);
        allGameObjects.addAll(this.breadStations);
        allGameObjects.addAll(this.meatStations);
        allGameObjects.addAll(this.tomatoStations);
        allGameObjects.addAll(this.lettuceStations);
        allGameObjects.addAll(this.plateStations);
        allGameObjects.addAll(this.trashcans);
        allGameObjects.addAll(this.washbasins);
        allGameObjects.addAll(this.parquetFloor);
        allGameObjects.add(this.player);
        return Collections.unmodifiableList(allGameObjects);
    }

    @Override
    public List<? extends AbstractStationObject> getAllStations() {
        final List<AbstractStationObject> allStationObjects = new LinkedList<>();
        allStationObjects.addAll(this.choppingStations);
        allStationObjects.addAll(this.counters);
        allStationObjects.addAll(this.cookers);
        allStationObjects.addAll(this.deliveryStations);
        allStationObjects.addAll(this.breadStations);
        allStationObjects.addAll(this.meatStations);
        allStationObjects.addAll(this.tomatoStations);
        allStationObjects.addAll(this.lettuceStations);
        allStationObjects.addAll(this.plateStations);
        allStationObjects.addAll(this.trashcans);
        allStationObjects.addAll(this.washbasins);
        return Collections.unmodifiableList(allStationObjects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerImpl getPlayer() {
        return this.player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameTimer getGameTimer() {
        return this.timer;
    }

    /**
     * @return the choppingStations
     */
    public Set<ChoppingStation> getChoppingStations() {
        return choppingStations;
    }

    /**
     * @return the cookers
     */
    public Set<Cooker> getCookers() {
        return cookers;
    }

    /**
     * @return the counters
     */
    public Set<Counter> getCounters() {
        return counters;
    }

    /**
     * @return the deliveryStations
     */
    public Set<DeliveryStation> getDeliveryStations() {
        return deliveryStations;
    }

    /**
     * @return the foodStations
     */
    public Set<BreadStation> getBreadStations() {
        return breadStations;
    }

    /**
     * @return the meatStations
     */
    public Set<MeatStation> getMeatStations() {
        return meatStations;
    }

    /**
     * @return the tomatoStations
     */
    public Set<TomatoStation> getTomatoStations() {
        return tomatoStations;
    }

    /**
     * @return the lettuceStations
     */
    public Set<LettuceStation> getLettuceStations() {
        return lettuceStations;
    }

    /**
     * @return the plateStations
     */
    public Set<PlateStation> getPlateStations() {
        return plateStations;
    }

    /**
     * @return the trashcans
     */
    public Set<Trashcan> getTrashcans() {
        return trashcans;
    }

    /**
     * @return the washbasins
     */
    public Set<Washbasin> getWashbasins() {
        return washbasins;
    }

    /**
     * @return the washbasins
     */
    public Set<ParquetFloor> getParquetFloor() {
        return parquetFloor;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public <X extends GameObject> void removeObject(final X object) {
    }

    @Override
    public <X extends Item> void removeItem(X item) {
        this.itemsInWorld.remove(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        // music update

        this.player.update();
        System.out.println(this.itemsInWorld.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Graphics2D g) {
        this.getAllGameObjects().forEach(o -> o.draw(g));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        // this.player.processInput();
    }

    private void createLevel(final TileManager tm, final SpriteManager sm, final String mapPath) {
        final WorldInitializer initializer = new WorldInitializerImpl(tm, sm, mapPath);
        this.choppingStations.addAll(initializer.initializeChoppingBoard());
        this.cookers.addAll(initializer.initializeCooker());
        this.counters.addAll(initializer.initializeCounter());
        this.deliveryStations.addAll(initializer.initializeDeliveryStation());
        this.breadStations.addAll(initializer.initializeBreadStation());
        this.meatStations.addAll(initializer.initializeMeatStation());
        this.tomatoStations.addAll(initializer.initializeTomatoStation());
        this.lettuceStations.addAll(initializer.initializeLettuceStation());
        this.plateStations.addAll(initializer.initializePlateStation());
        this.trashcans.addAll(initializer.initializeTrashcan());
        this.washbasins.addAll(initializer.initializeWashbasin());
        this.parquetFloor.addAll(initializer.initializeParquetFloor());
        this.player = initializer.initializePlayer(this);
    }

    @Override
    public void addItem(final Item item) {
        this.itemsInWorld.add(item);
    }

}
