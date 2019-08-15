package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.List;

import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.world.World;

/**
 * Order Manager Interface.
 *
 */
public interface OrdersManager {

    /**
     * Manage the submission of the plate from delivery board.
     * 
     * @param plate Plate submitted
     * @return True if they are the same
     */
    boolean deliveryPlate(Plate plate);

    /**
     * Update Method.
     */
    void update();

    /**
     * Draw Methods.
     * 
     * @param g Graphics2D
     */
    void draw(Graphics2D g);

    /**
     * Add an order to Current Order List.
     * 
     * @param order to be added
     */
    void addOrder(Order order);

    /**
     * @return N° of orders
     */
    int getOrderQuantity();

    /**
     * Manage a bad delivered order.
     * 
     * @param order to be placed on finished orders
     */
    void orderFailed(Order order);

    /**
     * @return List of current Orders
     */
    List<Order> getCurrentOrders();

    /**
     * @return List of finished Orders
     */
    List<Order> getFinishedOrders();

    /**
     * Start the orders generation.
     */
    void startGeneration();

    /**
     * Stop the orders generation.
     */
    void stopGeneration();

    /**
     * @return World
     */
    World getWorld();

    /**
     * Pause Generation Timer.
     */
    void pauseGeneration();

    /**
     * Resume Generation Timer.
     */
    void resumeGeneration();

    /**
     * Stop Orders Timers.
     */
    void stopOrders();

    /**
     * Pause Orders Timers.
     */
    void pauseOrders();

    /**
     * Resume Orders Timers.
     */
    void resumeOrders();
}
