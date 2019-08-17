package it.unibo.oop18.cfc.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.entity.Player;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.tilemap.TileMap;
import it.unibo.oop18.cfc.tilemap.TileMapImpl;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * Tests the correct implementation of the world.
 */
public class TestWorld {

    /**
     * Tests to remove all kind of object in the world.
     * @throws IOException 
     */
    @Test
    public void testStations() throws IOException {
        final int xMeatStation = 7;
        final int yMeatStation = 8;
        final int xPlateStation = 8;
        final int yPlateStation = 3;
        final int xCooker = 4;
        // World's initialization
        final World world = new WorldImpl();
        final Player player = world.getPlayer();
        // Initial player's is not in front of a food station
        player.getPosition().setX(xMeatStation * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPosition().setY(yMeatStation * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPhysics().getVelocity().setDirection(Direction.DOWN);
        //Get Meat
        player.doAction();
        Assert.assertTrue(player.getItemInHand().isPresent());
        Assert.assertTrue(player.getItemInHand().get() instanceof IngredientImpl);
        //Move in front of choppingStation and put the item in it
        player.getPosition().setX(3 * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.doAction();
        Assert.assertFalse(player.getItemInHand().isPresent());
        //Try the plateStation
        player.getPosition().setX(xPlateStation * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPosition().setY(yPlateStation * SpriteSheet.SPRITE_SIZE_IN_GAME);
        player.getPhysics().getVelocity().setDirection(Direction.UP);
        //Get Plate
        player.doAction();
        Assert.assertTrue(player.getItemInHand().isPresent());
        Assert.assertTrue(player.getItemInHand().get() instanceof PlateImpl);
        //Move to the cooker
        player.getPosition().setX(xCooker * SpriteSheet.SPRITE_SIZE_IN_GAME);
        // Take a chopped meat
        player.setItemInHand(new IngredientImpl(new ItemManager("/Sprites/itemSprite.png"), IngredientType.MEAT,
                IngredientState.CHOPPED));
        // Put in the cooker
        player.doAction();
        Assert.assertFalse(player.getItemInHand().isPresent());
        player.setItemInHand(new IngredientImpl(new ItemManager("/Sprites/itemSprite.png"), IngredientType.MEAT,
                IngredientState.RAW));
        // Cant put in the cooker ingredient not chopped
        player.doAction();
        Assert.assertTrue(player.getItemInHand().isPresent());
    }

    /**
     * Tests the map creation, see if match the bitmap.
     */
    @Test
    public void testReadMap() {
        final int xDelivery = 448;
        final int yDelivery = 128;
        final TileMap tm = new TileMapImpl("/Maps/testmap1.map");

        // Parquet position at the centre of the map
        Assert.assertTrue(tm.getParquetFloorPosition().stream().allMatch(
                p -> (p.getX() >= GameEngine.LEFT_BOUND_IN_PIXEL && p.getX() <= GameEngine.RIGHT_BOUND_IN_PIXEL)
                        && (p.getY() >= GameEngine.TOP_BOUND_IN_PIXEL && p.getY() <= GameEngine.DOWN_BOUND_IN_PIXEL)));

        // DeliveryStation on exact position and only one
        Assert.assertTrue(tm.getDeliveryStationPosition().size() == 1);
        if (tm.getDeliveryStationPosition().size() == 1) {
            Assert.assertTrue(tm.getDeliveryStationPosition().stream().findFirst().get().getX() == xDelivery);
            Assert.assertTrue(tm.getDeliveryStationPosition().stream().findFirst().get().getY() == yDelivery);
        }

        // Check if other station are the same number of the bitmap file
        Assert.assertTrue(tm.getTrashcanPosition().size() == 4);
        Assert.assertTrue(tm.getWashbasinPosition().size() == 1);
        Assert.assertTrue(tm.getPlateStationPosition().size() == 1);

        // Check only four station for cook and cut
        Assert.assertTrue(tm.getChoppingStationPosition().size() == 4);
        Assert.assertTrue(tm.getCookerPosition().size() == 4);

        // check only one sation for food
        Assert.assertTrue(tm.getMeatStationPosition().size() == 1);
        Assert.assertTrue(tm.getTomatoStationPosition().size() == 1);
        Assert.assertTrue(tm.getLettuceStationPosition().size() == 1);
        Assert.assertTrue(tm.getBreadStationPosition().size() == 1);
    }

    /**
     * Tests the timer used in the world.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testTimer() throws InterruptedException {
        // Timer's initialization
        final GameTimer timer = new GameTimer();
        // It has to be stopped at the beginning
        Assert.assertTrue(timer.isStopped());
        Assert.assertTrue(timer.getTimeMillis() == 0);
        // Timer gets started
        timer.start();
        long time = System.currentTimeMillis();
        Assert.assertFalse(timer.isStopped());
        timer.stop();
        Thread.sleep(1000);
        timer.resume();
        timer.stop();
        time = System.currentTimeMillis() - time;
        Assert.assertTrue(timer.isStopped());
        // Timer's reset test
        Assert.assertNotEquals(timer.getTimeMillis(), time);
        timer.reset();
        Assert.assertTrue(timer.isStopped());
        Assert.assertTrue(timer.getSeconds() == 0);
    }
}
