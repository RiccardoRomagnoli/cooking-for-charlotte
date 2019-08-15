package it.unibo.oop18.cfc.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

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
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;

/**
 * This class test some player features like input, movement and key/door
 * collision.
 */
public class TestOrders {

    private World world;

    /**
     * Test the correct generation of an order.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testGenerationOrder() throws IOException {
        // Class initialization
        this.world = new WorldImpl();
        final OrdersManager ordersMan = new OrdersManagerImpl(world);
        final OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
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
     * Test the submission of plates to the order manager.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testDeliveryAction() throws IOException {
        // World's initialization
        this.world = new WorldImpl();
        Order o;
        final Plate correctPlate;
        final Plate wrongPlate;
        final Plate correctPlateNotOrdered;
        correctPlate = new PlateImpl(world.getItemManager());
        wrongPlate = new PlateImpl(world.getItemManager());
        correctPlateNotOrdered = new PlateImpl(world.getItemManager());
        final OrdersManager ordersMan = new OrdersManagerImpl(world);
        final OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an order
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        o = ordersMan.getCurrentOrders().get(0);
        o.stopOrder();
        // Generate a Correct plate
        for (final OrderIngredient orderIngredient : o.getIngredientsList()) {
            correctPlate.addIngredient(new IngredientImpl(world.getItemManager(), orderIngredient.getIngredient(),
                    orderIngredient.getState()));
        }
        o = ordersMan.getCurrentOrders().get(1);
        o.stopOrder();
        // Generate a Wrong plate
        for (final OrderIngredient orderIngredient : o.getIngredientsList()) {
            wrongPlate.addIngredient(
                    new IngredientImpl(world.getItemManager(), IngredientType.BREAD, orderIngredient.getState()));
        }
        o = ordersMan.getCurrentOrders().get(2);
        o.stopOrder();
        // Generate a Correct plate in different ingredient order
        for (int i = o.getIngredientsList().size() - 1; i >= 0; i--) {
            final OrderIngredient orderIngredient = o.getIngredientsList().get(i);
            correctPlateNotOrdered.addIngredient(new IngredientImpl(world.getItemManager(),
                    orderIngredient.getIngredient(), orderIngredient.getState()));
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
     * an order expires.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testOrdersListUpdating() throws IOException {
        // Initialization
        this.world = new WorldImpl();
        final OrdersManager ordersMan = new OrdersManagerImpl(world);
        final OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an Order
        orderGen.generateNewOrder();
        final Order o = ordersMan.getCurrentOrders().get(0);
        Assert.assertTrue(ordersMan.getOrderQuantity() == 1);
        // Test Order Timer CountDown
        o.setCountDownTimer(1);
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(ordersMan.getCurrentOrders().size() == 0);
        Assert.assertTrue(ordersMan.getFinishedOrders().size() == 1);

    }

    /**
     * Throws IllegalStateException if more than 4 ingredients are inserted in an
     * order.
     *
     * @throws IllegalStateException the illegal state exception
     * @throws IOException           Signals that an I/O exception has occurred.
     */
    @Test(expected = IllegalStateException.class)
    public void testOrderIngredients() throws IllegalStateException, IOException {
        this.world = new WorldImpl();
        final OrdersManager ordersMan = new OrdersManagerImpl(world);
        final Order o = new OrderImpl(ordersMan);
        o.addIngredient(IngredientType.BREAD, IngredientState.CHOPPED);
        o.addIngredient(IngredientType.LETTUCE, IngredientState.RAW);
        o.addIngredient(IngredientType.MEAT, IngredientState.PERFECT);
        o.addIngredient(IngredientType.TOMATO, IngredientState.CHOPPED);
        o.addIngredient(IngredientType.MEAT, IngredientState.BURNED);
    }

    /**
     * Tests if orders are placed in order of their time of expire.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testOrdersListOrdering() throws IOException {
        // Initialization
        this.world = new WorldImpl();
        final OrdersManager ordersMan = new OrdersManagerImpl(world);
        final OrderGenerator orderGen = new OrderGeneratorImpl(ordersMan);
        // Generate an Order
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        orderGen.generateNewOrder();
        final Order o1 = ordersMan.getCurrentOrders().get(0);
        o1.stopOrder();
        final Order o2 = ordersMan.getCurrentOrders().get(1);
        o2.stopOrder();
        final Order o3 = ordersMan.getCurrentOrders().get(2);
        o3.stopOrder();
        // Test Order Timer CountDown
        o1.setCountDownTimer(2 * 3 * 10);
        o2.setCountDownTimer(2 * 2 * 10);
        o3.setCountDownTimer(2 * 10);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(0) == o3);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(1) == o2);
        Assert.assertTrue(ordersMan.getCurrentOrders().get(2) == o1);

    }
}
