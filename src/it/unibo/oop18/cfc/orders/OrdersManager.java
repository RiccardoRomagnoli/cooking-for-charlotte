package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.List;

import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.world.World;

public interface OrdersManager {

    /**
     * Manage the submission of the plate from delivery board
     * 
     * @param plate Plate submitted
     * @return True if they are the same
     */
    public boolean deliveryPlate(Plate plate);

    public void update();

    public void draw(Graphics2D g);

    public void addOrder(Order o);

    public int getOrderQuantity();

    public void orderFailed(Order o);

    public List<Order> getCurrentOrders();

    public List<Order> getFinishedOrders();

    public void startGeneration();

    public void stopGeneration();

    public World getWorld();

    void pauseGeneration();

    void resumeGeneration();

    public void stopOrders();

    public void pauseOrders();

    public void resumeOrders();
}
