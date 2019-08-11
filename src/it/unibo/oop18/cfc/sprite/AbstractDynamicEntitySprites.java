package it.unibo.oop18.cfc.sprite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unibo.oop18.cfc.physics.Direction;

/**
 * Class that manages enemies and player {@link Sprite}.
 */
public abstract class AbstractDynamicEntitySprites {

    private final HashMap<Direction, Sprite> stop;
    private final List<Sprite> left;
    private final List<Sprite> right;
    private final List<Sprite> down;
    private final List<Sprite> up;

    /**
     * Creates a {@code AbstractEntitySprites} that initializes all sprite lists for
     * any movement.
     */
    public AbstractDynamicEntitySprites() {
        this.stop = new HashMap<Direction, Sprite>();
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    /**
     * Gets the sprite for stop animation.
     *
     * @return list of {@link Sprite} to represent a still entity
     */
    public HashMap<Direction, Sprite> getStopSprites() {
        return this.stop;
    }

    /**
     * Gets the sprite for movement left animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes left
     */
    public List<Sprite> getLeftSprites() {
        return this.left;
    }

    /**
     * Gets the sprite for movement right animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes right
     */
    public List<Sprite> getRightSprites() {
        return this.right;
    }

    /**
     * Gets the sprite for movement down animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes down
     */
    public List<Sprite> getDownSprites() {
        return this.down;
    }

    /**
     * Gets the sprite for movement up animation.
     *
     * @return list of {@link Sprite} to represent an entity that goes up
     */
    public List<Sprite> getUpSprites() {
        return this.up;
    }

    /**
     * Gets the greater list sprite size.
     *
     * @return the max size of any list of {@link Sprite}
     */
    public abstract int getSpritesNumberToMove();

}
