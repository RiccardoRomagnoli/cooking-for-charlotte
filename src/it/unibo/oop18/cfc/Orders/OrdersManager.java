package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.World.World;

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
    
    public ArrayList<Order> getCurrentOrders();

    public ArrayList<Order> getFinishedOrders();
    
    public void startGeneration();
    
    public void stopGeneration();
    
    public World getWorld();
}
