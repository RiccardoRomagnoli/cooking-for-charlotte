package it.unibo.oop18.cfc.sprite;

import it.unibo.oop18.cfc.physics.Direction;

/**
 * Class that manages player {@link Sprite}.
 */
public class PlayerSprites extends AbstractDynamicEntitySprites {

    private static final int SPRITES_TO_MOVE = 4;
    private static final int Y_LOCATION_MOVE_LEFT = 1;
    private static final int Y_LOCATION_MOVE_RIGHT = 2;
    private static final int Y_LOCATION_MOVE_UP = 3;
    private static final int Y_LOCATION_MOVE_DOWN = 0;
    private static final int X_LOCATION_STOP = 0;

    /**
     * Creates a {@link PlayerSprites} that initializes all sprite lists for any
     * movement.
     * 
     * @param sheet the {@link SpriteSheet} to take images
     */
    public PlayerSprites(final SpriteSheet sheet) {
        super();
        for (int i = 0; i < SPRITES_TO_MOVE; i++) {
            super.getRightSprites().add(new Sprite(sheet, i, Y_LOCATION_MOVE_RIGHT));
            super.getLeftSprites().add(new Sprite(sheet, i, Y_LOCATION_MOVE_LEFT));
            super.getDownSprites().add(new Sprite(sheet, i, Y_LOCATION_MOVE_DOWN));
            super.getUpSprites().add(new Sprite(sheet, i, Y_LOCATION_MOVE_UP));
        }
        super.getStopSprites().put(Direction.DOWN, new Sprite(sheet, X_LOCATION_STOP, 0));
        super.getStopSprites().put(Direction.LEFT, new Sprite(sheet, X_LOCATION_STOP, 1));
        super.getStopSprites().put(Direction.RIGHT, new Sprite(sheet, X_LOCATION_STOP, 2));
        super.getStopSprites().put(Direction.UP, new Sprite(sheet, X_LOCATION_STOP, 3));
    }

    /**
     * Gets the list of player sprite size.
     *
     * @return the size of player {@link Sprite} size
     */
    public int getSpritesNumberToMove() {
        return SPRITES_TO_MOVE;
    }

}
