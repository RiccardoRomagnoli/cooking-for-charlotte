package it.unibo.oop18.cfc.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import it.unibo.oop18.cfc.Main.GameEngine;
import it.unibo.oop18.cfc.Manager.ItemManager;
import it.unibo.oop18.cfc.Objects.Entity.Player;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Orders.Order;
import it.unibo.oop18.cfc.Orders.OrderGenerator;
import it.unibo.oop18.cfc.Orders.OrderGeneratorImpl;
import it.unibo.oop18.cfc.Orders.OrderImpl;
import it.unibo.oop18.cfc.Orders.OrdersManager;
import it.unibo.oop18.cfc.Orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.Physics.Direction;
import it.unibo.oop18.cfc.Sprite.SpriteSheet;
import it.unibo.oop18.cfc.Util.Position;
import it.unibo.oop18.cfc.World.World;
import it.unibo.oop18.cfc.World.WorldImpl;

/**
 * This class test some player features like input, movement and key/door collision.
 */
public class TestOrders {

    private World world;

    /**
     * Test the correct generation of an order
     *
     * @throws IOException
     */
    @Test
    public void testGenerationOrder() throws IOException {
        //Class initialization
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        orderGen.generateNewOrder();
        //Test effective creation
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        //Clear
        ordersMan.getCurrentOrders().clear();
        //Test default creation if 0 orders
        ordersMan.update();
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        //Test 4 order limit
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        Assert.assertTrue(ordersMan.getOrderQuantity() == 4);        
    }

    /**
     * Test the submission of a plate to the order checker
     *
     * @throws IOException 
     */
    @Test
    public void testDeliveryAction() throws IOException {
        //World's initialization
        this.world = new WorldImpl();
    }

    /**
     * Checks if current list and finished list of orders 
     * are correctly updated when an order expires
     *
     * @throws IOException 
     */
    @Test
    public void testOrdersListUpdating() throws IOException {
        //Classic initialization
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        //Test Order Timer CountDown
        orderGen.generateNewOrder();
        Order o = ordersMan.getCurrentOrders().get(0);
        Assert.assertTrue(ordersMan.getOrderQuantity()==1);
        o.setCountDownTimer(1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(ordersMan.getCurrentOrders().size()==0);
        Assert.assertTrue(ordersMan.getFinishedOrders().size()==1);

    }

    /**
     * Throws IllegalStateException if more than 4 ingredients are inserted in an order
     *
     * @throws IOException 
     */
    @Test(expected = IllegalStateException.class)
    public void testOrderIngredients() throws IllegalStateException, IOException {
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        Order o = new OrderImpl(ordersMan);
        o.addIngredient(IngredientType.BREAD, IngredientState.CHOPPED);
        o.addIngredient(IngredientType.LETTUCE, IngredientState.RAW);
        o.addIngredient(IngredientType.MEAT, IngredientState.PERFECT);
        o.addIngredient(IngredientType.TOMATO, IngredientState.CHOPPED);
        o.addIngredient(IngredientType.MEAT, IngredientState.BURNED);
    }
}
