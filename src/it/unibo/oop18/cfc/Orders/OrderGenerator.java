package it.unibo.oop18.cfc.Orders;

public interface OrderGenerator {

	public void setDifficulty(OrderDifficulty currentDifficulty);
	
	public void startGeneration(long intervalMilliseconds);
}
