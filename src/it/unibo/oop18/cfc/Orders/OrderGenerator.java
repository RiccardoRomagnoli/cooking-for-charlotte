package it.unibo.oop18.cfc.Orders;

public interface OrderGenerator {
	
	/**
	 * Generate a new random Order
	 * 
	 * @param difficulty Criteria of generation for the new Order
	 * @return Order generated
	 */
	public Order generateNewOrder(OrderDifficulty difficulty);
}
