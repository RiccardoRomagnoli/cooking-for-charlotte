package it.unibo.oop18.cfc.Orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Optional;

import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Util.GameTimer;
import it.unibo.oop18.cfc.World.World;

public class OrdersManagerImpl implements OrdersManager {

    private static final long INTERVAL_MILLISECONDS = 30000;
    private final ArrayList<Order> currentOrders;
    private final ArrayList<Order> finishedOrders;
    private GameTimer gameTimer;
    private final OrderGenerator generator;
    private final World world;

    public OrdersManagerImpl(World world) {
        this.world = world;
        currentOrders = new ArrayList<>();
        finishedOrders = new ArrayList<>();
        gameTimer = world.getGameTimer();
        generator = new OrderGeneratorImpl(this);
        generator.startGeneration(INTERVAL_MILLISECONDS);
    }   
    
    @Override
    public boolean deliveryPlate(Plate plate) {
        Optional<Order> order = checkOrder(plate);
        if (order.isPresent()) {
            orderSucceed(order.get());
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
        checkZeroOrders();
    }

    @Override
    public void addOrder(Order o) {
        this.currentOrders.add(o);
    }
	
    @Override
    public int getOrderQuantity() {
        return currentOrders.size();
    }
    
    @Override
    public void orderFailed(Order order) {
        currentOrders.remove(order);
        finishedOrders.add(order);
        this.world.lifeLoss();
    }

    private Optional<Order> checkOrder(Plate plate) {
        Optional<Order> returnOrder = Optional.empty();
        for (Order order : currentOrders) {
            if (order.checkOrder(plate))
                returnOrder = Optional.ofNullable(order);
        }
        return returnOrder;
    }   
    
    private void orderSucceed(Order order) {
        currentOrders.remove(order);
        finishedOrders.add(order);
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
    
    private void checkZeroOrders() {
        if(currentOrders.size() == 0) {
            generator.generateNewOrder();
        }
    }
}
