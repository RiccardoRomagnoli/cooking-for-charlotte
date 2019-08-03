package it.unibo.oop18.cfc.Orders;

import java.util.Timer;
import java.util.TimerTask;

public class OrderGeneratorImpl extends TimerTask implements OrderGenerator {

	private final Timer timer;
	private OrderDifficulty currentDifficulty;
	
	public OrderGeneratorImpl() {
		 timer = new Timer();
	}
	
	@Override
	public void startGeneration(long intervalMilliseconds){
		timer.schedule(new OrderGeneratorImpl(), 0, intervalMilliseconds);
	}
	
	
	/**
	 * Generate a new random Order based on difficulty
	 * 
	 * @param difficulty Criteria of generation for the new Order
	 * @return Order generated
	 */
	private Order generateNewOrder() {
		Order o;
		switch(currentDifficulty) {
		case EASY:
			o = generateEasyOrder();
			break;
		case MEDIUM:
			o = generateMediumOrder();
			break;
		case HARD:
			o = generateHardOrder();
			break;
		case EXTREME:
			o = generateExtremeOrder();
			break;
		default:
			o = generateEasyOrder();
			break;
				
		}
		return o;
	}
	
	private Order generateExtremeOrder() {
		Order o = new OrderImpl();
		return o;
	}

	private Order generateHardOrder() {
		Order o = new OrderImpl();
		return o;
	}

	private Order generateMediumOrder() {
		Order o = new OrderImpl();
		return o;
	}

	private Order generateEasyOrder() {
		Order o = new OrderImpl();
		return o;
	}

	public void run() {
		generateNewOrder();
	}

	@Override
	public void setDifficulty(OrderDifficulty difficulty) {
		currentDifficulty = difficulty;
	}
}
