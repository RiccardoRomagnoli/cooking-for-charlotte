package it.unibo.oop18.cfc.Manager;

import java.io.IOException;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;

/**
 * This class stores and gets any kind of sprite in game.
 */
public class TileManager {

    private static final int Y_LOCATION = 1;
    private static final int WALL_X_LOCATION = 1;
    private static final int BREAKABLE_WALL_X_LOCATION = 2;
    private static final int KEY_X_LOCATION = 3;
    private static final int FLOOR_X_LOCATION = 6;
    private static final int ENEMY_Y_LOCATION = 7;
    private static final int GHOST_Y_LOCATION = 13;
    private static final int SMART_ENEMY_LOCATION = 18;

    private final Sprite wall;
    private final Sprite breakableWall;
    private final Sprite key;
    private final Sprite floor;


    /**
     * Creates a {@code SpritesManager} to manage any {@link Sprite} in game.
     *
     * @param folder theme
     * @throws IOException : problem during input/output
     */
    public TileManager(final String folder) throws IOException {
        final TileSheet sheet = new TileSheet(folder + "/spriteSheet.png");
        this.breakableWall = new Sprite(sheet, BREAKABLE_WALL_X_LOCATION, Y_LOCATION);
        this.wall = new Sprite(sheet, WALL_X_LOCATION, Y_LOCATION);
        this.key = new Sprite(sheet, KEY_X_LOCATION, Y_LOCATION);
        this.floor = new Sprite(sheet, FLOOR_X_LOCATION, Y_LOCATION);
        this.door = new DoorSprite(sheet);
        this.player = new PlayerSprites(sheet);
        this.enemy = new EnemySprites(sheet, ENEMY_Y_LOCATION);
        this.bomb = new ChoppingStation(sheet);
        this.flame = new FlameSprites(sheet);
        this.ghost = new EnemySprites(sheet, GHOST_Y_LOCATION);
        this.smartEnemy = new EnemySprites(sheet, SMART_ENEMY_LOCATION);
    }

    /**
     * Gets the wall sprite.
     *
     * @return wall {@link Sprite}
     */
    public Sprite getWallSprite() {
        return this.wall;
    }

    /**
     * Gets the breakable wall sprite.
     *
     * @return breakable wall {@link Sprite}.
     */
    public Sprite getBreakableWallSprite() {
        return this.breakableWall;
    }

    /**
     * Gets the key sprite.
     *
     * @return key {@link Sprite}
     */
    public Sprite getKeySprite() {
        return this.key;
    }

    /**
     * Gets the floor sprite.
     *
     * @return floor {@link Sprite}
     */
    public Sprite getFloorSprite() {
        return this.floor;
    }

    /**
     * Gets the door sprite container.
     *
     * @return {@link DoorSprite}
     */
    public DoorSprite getDoorSprite() {
        return this.door;
    }

    /**
     * Gets the player sprite container.
     *
     * @return {@link PlayerSprites}
     */
    public PlayerSprites getPlayerSprite() {
        return this.player;
    }

    /**
     * Gets the enemy sprite container.
     *
     * @return {@link EnemySprites}
     */
    public EnemySprites getEnemySprite() {
        return this.enemy;
    }

    /**
     * Gets the ghost sprite container.
     *
     * @return ghost {@link EnemySprites}
     */
    public EnemySprites getGhost() {
        return this.ghost;
    }

    /**
     * Gets the smart enemy sprite container.
     *
     * @return smart enemy {@link EnemySprites}
     */
    public EnemySprites getSmartEnemy() {
        return this.smartEnemy;
    }

    /**
     * Gets bomb sprite container.
     *
     * @return {@link ChoppingStation}
     */
    public ChoppingStation getBomb() {
        return this.bomb;
    }

    /**
     * Gets flame sprite container.
     *
     * @return {@link FlameSprites}
     */
    public FlameSprites getFlame() {
        return this.flame;
    }

}
