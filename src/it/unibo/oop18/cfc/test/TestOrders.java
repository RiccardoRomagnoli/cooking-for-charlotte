package it.unibo.oop18.cfc.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import it.unibo.oop18.cfc.main.GameEngine;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.entity.Player;
import it.unibo.oop18.cfc.object.items.Ingredient;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.object.items.OrderIngredient;
import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.object.items.PlateImpl;
import it.unibo.oop18.cfc.orders.Order;
import it.unibo.oop18.cfc.orders.OrderGenerator;
import it.unibo.oop18.cfc.orders.OrderGeneratorImpl;
import it.unibo.oop18.cfc.orders.OrderImpl;
import it.unibo.oop18.cfc.orders.OrdersManager;
import it.unibo.oop18.cfc.orders.OrdersManagerImpl;
import it.unibo.oop18.cfc.physics.Direction;
import it.unibo.oop18.cfc.sprite.SpriteSheet;
import it.unibo.oop18.cfc.util.Position;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * This class test some player features like input, movement and key/door
 * collision.
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
        // Class initialization
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        orderGen.generateNewOrder();
        // Test effective creation
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        // Clear
        ordersMan.getCurrentOrders().clear();
        // Test default creation if 0 orders
        ordersMan.update();
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        // Test 4 order limit
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        Assert.assertTrue(ordersMan.getOrderQuantity() == 4);
    }

    /**
     * Test the submission of plates to the order manager
     *
     * @throws IOException
     */
    @Test
    public void testDeliveryAction() throws IOException {
        // World's initialization
        this.world = new WorldImpl();
        Order o;
        Plate correctPlate;
        Plate wrongPlate;
        Plate correctPlateNotOrdered;
        correctPlate = new PlateImpl(world.getItemManager());
        wrongPlate = new PlateImpl(world.getItemManager());
        correctPlateNotOrdered = new PlateImpl(world.getItemManager());
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an order
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        o = ordersMan.getCurrentOrders().get(0);
        o.stopOrder();
        // Generate a Correct plate
        for (OrderIngredient orderIngredient : o.getIngredientsList()) {
            correctPlate.addDish(new IngredientImpl(world.getItemManager(), orderIngredient.getIngredient(),
                    orderIngredient.getState()));
        }
        o = ordersMan.getCurrentOrders().get(1);
        o.stopOrder();
        // Generate a Wrong plate
        for (OrderIngredient orderIngredient : o.getIngredientsList()) {
            wrongPlate.addDish(
                    new IngredientImpl(world.getItemManager(), IngredientType.BREAD, orderIngredient.getState()));
        }
        o = ordersMan.getCurrentOrders().get(2);
        o.stopOrder();
        // Generate a Correct plate in different ingredient order
        for (int i = o.getIngredientsList().size() - 1; i >= 0; i--) {
            OrderIngredient orderIngredient = o.getIngredientsList().get(i);
            correctPlateNotOrdered.addDish(new IngredientImpl(world.getItemManager(), orderIngredient.getIngredient(),
                    orderIngredient.getState()));
        }
        // Test correct Delivery
        Assert.assertTrue(ordersMan.deliveryPlate(correctPlate));
        // Test wrong Delivery
        Assert.assertFalse(ordersMan.deliveryPlate(wrongPlate));
        // Test correct Delivery in casual ingredient position
        Assert.assertTrue(ordersMan.deliveryPlate(correctPlateNotOrdered));
    }

    /**
     * Checks if current list and finished list of orders are correctly updated when
     * an order expires
     *
     * @throws IOException
     */
    @Test
    public void testOrdersListUpdating() throws IOException {
        // Initialization
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an Order
        orderGen.generateNewOrder();
        Order o = ordersMan.getCurrentOrders().get(0);
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        // Test Order Timer CountDown
        o.setCountDownTimer(1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(ordersMan.getCurrentOrders().size() == 0);
        Assert.assertTrue(ordersMan.getFinishedOrders().size() == 1);

    }

    /**
     * Throws IllegalStateException if more than 4 ingredients are inserted in an
     * order
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

    /**
     * Tests if orders are placed in order of their time of expire
     * 
     * @throws IOException
     */
    @Test
    public void testOrdersListOrdering() throws IOException {
        // Initialization
        this.world = new WorldImpl();
        OrdersManager ordersMan = new OrdersManagerImpl(world);
        OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an Order
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        Order o1 = ordersMan.getCurrentOrders().get(0);
        o1.stopOrder();
        Order o2 = ordersMan.getCurrentOrders().get(1);
        o2.stopOrder();
        Order o3 = ordersMan.getCurrentOrders().get(2);
        o3.stopOrder();
        // Test Order Timer CountDown
        o1.setCountDownTimer(60);
        o2.setCountDownTimer(40);
        o3.setCountDownTimer(20);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(0) == o3);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(1) == o2);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(2) == o1);

    }
}
