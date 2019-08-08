package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Objects.Items.Plate;

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
}
