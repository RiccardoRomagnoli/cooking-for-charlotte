package it.unibo.oop18.cfc.TileMap;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import it.unibo.oop18.cfc.Physics.Direction;

/**
 * Class that manages enemies and player {@link Sprite}.
 */
public class PlayerSprites {

	private static final int SPRITES_TO_MOVE = 4;
	
    private final List<Tile> left;
    private final List<Tile> right;
    private final List<Tile> down;
    private final List<Tile> up;
    private final HashMap<Direction, Tile> stop;

    /**
     * Creates a {@code AbstractEntitySprites} that initializes all sprite lists for any movement.
     */
    public PlayerSprites(BufferedImage[][] EntitySprite) {
    	this.stop = new HashMap<>();
    	stop.put(Direction.STOP, new Tile(EntitySprite[0][0]));
    	stop.put(Direction.DOWN, new Tile(EntitySprite[0][0]));
    	stop.put(Direction.LEFT, new Tile(EntitySprite[1][0]));
    	stop.put(Direction.RIGHT, new Tile(EntitySprite[2][0]));
    	stop.put(Direction.UP, new Tile(EntitySprite[3][0]));

        this.left = new ArrayList<>();
        left.addAll(Arrays.asList(new Tile(EntitySprite[1][0]),
        						  new Tile(EntitySprite[1][1]),
        						  new Tile(EntitySprite[1][2]),
        						  new Tile(EntitySprite[1][3])));
        this.right = new ArrayList<>();
        right.addAll(Arrays.asList(new Tile(EntitySprite[2][0]),
				  				   new Tile(EntitySprite[2][1]),
				  				   new Tile(EntitySprite[2][2]),
				  				   new Tile(EntitySprite[2][3])));
        this.up = new ArrayList<>();
        up.addAll(Arrays.asList(new Tile(EntitySprite[3][0]),
				  			    new Tile(EntitySprite[3][1]),
				  			    new Tile(EntitySprite[3][2]),
				  			    new Tile(EntitySprite[3][3])));
        this.down = new ArrayList<>();
        down.addAll(Arrays.asList(new Tile(EntitySprite[0][0]),
				  				  new Tile(EntitySprite[0][1]),
				  				  new Tile(EntitySprite[0][2]),
				  				  new Tile(EntitySprite[0][3])));
    }

    /**
     * Gets the sprite for stop animation.
     *
     * @return list of {@link Sprite} to represent a still entity
     */
    public Tile getStopSprites(Direction dir) {
        return this.stop.get(dir);
    }

    /**
     * Gets the sprite for movement left animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes left
     */
    public List<Tile> getLeftSprites() {
        return this.left;
    }

    /**
     * Gets the sprite for movement right animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes right
     */
    public List<Tile> getRightSprites() {
        return this.right;
    }

    /**
     * Gets the sprite for movement down animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes down
     */
    public List<Tile> getDownSprites() {
        return this.down;
    }

    /**
     * Gets the sprite for movement up animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes up
     */
    public List<Tile> getUpSprites() {
        return this.up;
    }

    /**
     * Gets the greater list sprite size.
     *
     * @return the max size of any list of {@link Sprite}
     */
    public int getSpritesNumberToMove() {
    	return SPRITES_TO_MOVE;
    }

}
