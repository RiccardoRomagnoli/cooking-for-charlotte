package it.unibo.oop18.cfc.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.entity.Player;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * This class test some player features like input, movement and key/door
 * collision.
 */
public class TestPlayer {

    private static final int START_POSOTION = 7;
    /** The Constant ITEMPATH. */
    public static final String ITEMPATH = "/Sprites/itemSprite.png";
    private static final int PIXEL_PER_SECOND = 4 * 16;
    private static final Position INITIAL_POSITION = new Position(START_POSOTION * SpriteSheet.SPRITE_SIZE_IN_GAME,
            START_POSOTION * SpriteSheet.SPRITE_SIZE_IN_GAME);
    private static final int Y_LOCATION_MOVE_UP = 6;

    private World world;

    /**
     * Tests the player's position.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testPlayerPosition() throws IOException {
        final int testypos = 6;
        final int testxpos = 8;
        // World's initialization
        this.world = new WorldImpl(new GameStateManager());
        // World graphic component closed
        final Player player = world.getPlayer();
        // Player is not in position (0, 0)
        Assert.assertFalse(player.getPosition().equals(new Position(0, 0)));
        // Player is in position (7, 7)
        Assert.assertTrue(player.getPosition().equals(INITIAL_POSITION));
        // Player is not moving because there's no input
        player.getPhysics().move();
        Assert.assertTrue(player.getPosition().equals(INITIAL_POSITION));
        // Player was moved in position (8, 7)
        player.getPosition().setX(testxpos * SpriteSheet.SPRITE_SIZE_IN_GAME);
        Assert.assertFalse(player.getPosition().equals(INITIAL_POSITION));
        Assert.assertTrue(player.getPosition().equals(new Position(testxpos * SpriteSheet.SPRITE_SIZE_IN_GAME,
                START_POSOTION * SpriteSheet.SPRITE_SIZE_IN_GAME)));
        // Player was moved in position (8, 6)
        player.getPosition().setY(testypos * SpriteSheet.SPRITE_SIZE_IN_GAME);
        Assert.assertTrue(player.getPosition().equals(
                new Position(testxpos * SpriteSheet.SPRITE_SIZE_IN_GAME, testypos * SpriteSheet.SPRITE_SIZE_IN_GAME)));
    }

    /**
     * Tests player taking an ingredient from a Station.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testDoAcion() throws IOException {
        // World's initialization
        this.world = new WorldImpl(new GameStateManager());
        final Player player = world.getPlayer();
        // Initial player's is not in front of a food station
        player.getPosition().setX(START_POSOTION * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPosition().setY(START_POSOTION * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPhysics().getVelocity().setDirection(Direction.DOWN);
        player.doAction();
        Assert.assertFalse(player.getItemInHand().isPresent());
        // Player's is in front of a food station
        player.getPosition().setY(8 * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.doAction();
        Assert.assertTrue(player.getItemInHand().isPresent());
    }

    /**
     * Tests the player input.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testPlayerInput() throws IOException {
        // World's initialization
        this.world = new WorldImpl(new GameStateManager());
        final Player player = world.getPlayer();
        // Checks if player is not moving
        Assert.assertTrue(player.getPhysics().getVelocity().getDirection().equals(Direction.STOP));
        // Simulates an input command
        player.getInput().createDirectionCommand(Direction.RIGHT, PIXEL_PER_SECOND);
        player.update();
        // Checks if player is moved from his starting position
        Assert.assertFalse(player.getPosition().equals(INITIAL_POSITION));
        // Simulates another input command
        player.getInput().createDirectionCommand(Direction.LEFT, PIXEL_PER_SECOND);
        player.update();
        // Checks if player is back to the starting position
        Assert.assertTrue(player.getPosition().equals(INITIAL_POSITION));
    }

    /**
     * Tests a wrong index in food sprite list with a player sprite id.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSprites() throws IOException {
        final ItemManager itemManager = new ItemManager(ITEMPATH);
        itemManager.getFoodSprites().getIngredientSprite().get(IngredientType.BREAD.getX()).get(Y_LOCATION_MOVE_UP);
    }
}
