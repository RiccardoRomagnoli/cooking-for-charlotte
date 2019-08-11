package it.unibo.oop18.cfc.world;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.oop18.cfc.gamestate.GameState;
import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.manager.SpriteManager;
import it.unibo.oop18.cfc.manager.TileManager;
import it.unibo.oop18.cfc.object.GameObject;
import it.unibo.oop18.cfc.object.Entity.PlayerImpl;
import it.unibo.oop18.cfc.object.Floors.ParquetFloor;
import it.unibo.oop18.cfc.object.Items.Item;
import it.unibo.oop18.cfc.object.Items.PlateImpl;
import it.unibo.oop18.cfc.object.Stations.AbstractStationObject;
import it.unibo.oop18.cfc.object.Stations.BreadStation;
import it.unibo.oop18.cfc.object.Stations.ChoppingStation;
import it.unibo.oop18.cfc.object.Stations.Cooker;
import it.unibo.oop18.cfc.object.Stations.Counter;
import it.unibo.oop18.cfc.object.Stations.DeliveryStation;
import it.unibo.oop18.cfc.object.Stations.LettuceStation;
import it.unibo.oop18.cfc.object.Stations.MeatStation;
import it.unibo.oop18.cfc.object.Stations.PlateStation;
import it.unibo.oop18.cfc.object.Stations.TomatoStation;
import it.unibo.oop18.cfc.object.Stations.Trashcan;
import it.unibo.oop18.cfc.object.Stations.Washbasin;
import it.unibo.oop18.cfc.orders.OrdersManager;
import it.unibo.oop18.cfc.orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.tile.TileSheet;
import it.unibo.oop18.cfc.util.GameTimer;

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
    /**
     * Path to player Sprite.
     */
    public static final String ITEMPATH = "/Sprites/itemSprite.png";

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

    private PlayerImpl player;
    private final GameTimer timer;
    // private final PlayerScore score;

    private final TileManager tileManager;
    private final SpriteManager spriteManager;
    private final ItemManager itemManager;
    private final OrdersManager ordersManager;
    /**
     * Creates a {@code WorldImpl}.
     * 
     * @throws IOException on tilemanager error
     *
     */
    public WorldImpl() throws IOException {
        this.timer = new GameTimer();
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
        this.tileManager = new TileManager(TILEPATH);
        this.spriteManager = new SpriteManager(SPRITEPATH);
        this.itemManager = new ItemManager(ITEMPATH);
        this.ordersManager = new OrdersManagerImpl(this);
        this.createLevel();
        timer.start();
    }

    /**
     * @return the tileManager
     */
    public TileManager getTileManager() {
        return tileManager;
    }

    /**
     * @return the spriteManager
     */
    public SpriteManager getSpriteManager() {
        return spriteManager;
    }

    /**
     * @return the itemManager
     */
    public ItemManager getItemManager() {
        return itemManager;
    }

    /**
     * @return the ordersManager
     */
    @Override
    public OrdersManager getOrdersManager() {
        return ordersManager;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.player.update();
        this.choppingStations.forEach(c -> c.update());
        this.cookers.forEach(c -> c.update());
        this.ordersManager.update();
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

    private void createLevel() {
        final WorldInitializer initializer = new WorldInitializerImpl(tileManager, spriteManager, itemManager, MAPPATH);
        this.choppingStations.addAll(initializer.initializeChoppingBoard(this));
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
        this.ordersManager.startGeneration();
    }

}
