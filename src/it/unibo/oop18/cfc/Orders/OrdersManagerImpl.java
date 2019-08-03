package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Optional;

import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.World.World;

public class OrdersManagerImpl implements OrdersManager {

	private static final long INTERVAL_MILLISECONDS = 30000;
	// world timer?
	private final ArrayList<Order> currentOrders;
	private final ArrayList<Order> finishedOrders;
	private GameTimer gameTimer;
	private final OrderGenerator generator;

	public OrdersManagerImpl(World world) {
		currentOrders = new ArrayList<>();
		finishedOrders = new ArrayList<>();
		gameTimer = world.getGameTimer();
		generator = new OrderGeneratorImpl();
		generator.startGeneration(INTERVAL_MILLISECONDS);
	}

	@Override
	public boolean deliveryPlate(Plate plate) {
		Optional<Order> order = checkOrder(plate);
		if (order.isPresent()) {
			updateOrder(order.get());
		}

		return order.isPresent();
	}

	@Override
	public void draw(Graphics2D g) {
		// delega il draw a tutti gli ordini settandogli lo slot = index della lista
		// ordinata per tempo dell'ordine
	}

	@Override
	public void update() {
		updateDifficulty();
	}
	
	@Override
	public void addOrder(Order o) {
		this.currentOrders.add(o);
	}
	
	@Override
	public int getOrderQuantity() {
		return currentOrders.size();
	}

	private Optional<Order> checkOrder(Plate plate) {
		Optional<Order> returnOrder = Optional.empty();
		for (Order order : currentOrders) {
			if (order.checkOrder(plate))
				returnOrder = Optional.ofNullable(order);
		}
		return returnOrder;
	}

	private void updateOrder(Order order) {

	}

	private void updateDifficulty() {
		int currentMinute = (int) gameTimer.getMinutes();
		OrderDifficulty currentDifficulty = OrderDifficulty.EASY;
		
		if (currentMinute > 2) {
			currentDifficulty = OrderDifficulty.MEDIUM;
		}
		if (currentMinute > 8) {
			currentDifficulty = OrderDifficulty.HARD;
		}
		if (currentMinute > 16) {
			currentDifficulty = OrderDifficulty.EXTREME;
		}
		generator.setDifficulty(currentDifficulty);
	}
}
