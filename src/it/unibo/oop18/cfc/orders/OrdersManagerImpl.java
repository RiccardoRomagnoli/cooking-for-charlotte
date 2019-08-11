package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Optional;

import it.unibo.oop18.cfc.graphics.GraphicsComponent;
import it.unibo.oop18.cfc.graphics.OrderGraphicComponent;
import it.unibo.oop18.cfc.object.Items.Plate;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.world.World;

public class OrdersManagerImpl implements OrdersManager {

    private static final long INTERVAL_MILLISECONDS = 30000;
    private final ArrayList<Order> currentOrders;
    private final ArrayList<Order> finishedOrders;
    private GameTimer gameTimer;
    private final OrderGeneratorImpl generator;
    private final World world;

    public OrdersManagerImpl(World world) {
        this.world = world;
        currentOrders = new ArrayList<>();
        finishedOrders = new ArrayList<>();
        gameTimer = world.getGameTimer();
        generator = new OrderGeneratorImpl(this);
    }   

    public World getWorld() {
        return world;
    }

    @Override
    public boolean deliveryPlate(Plate plate) {
        Optional<Order> order = checkOrder(plate);
        if (order.isPresent()) {
            orderSucceed(order.get());
        }
        return order.isPresent();
    }

    /**
     * delegates draw of each order by setting them their slot
     * which is the index of order list
     */
    @Override
    public void draw(Graphics2D g) {
        currentOrders.stream().forEach(o->{
            o.setSlot(currentOrders.indexOf(o));
            o.draw(g);
        });
    }
    
    @Override
    public void update() {
        //generator(timertask) work with timers that call run
        //this is the alternative solution call every time in update
        //generator.run();
        updateDifficulty();
        checkZeroOrders();
    }

    @Override
    public void addOrder(Order o) {
        this.currentOrders.add(o);
        this.currentOrders.sort((o1, o2) -> o1.getCountDownTime() - o2.getCountDownTime());
    }
	
    @Override
    public int getOrderQuantity() {
        return currentOrders.size();
    }
    
    @Override
    public void orderFailed(Order order) {
        currentOrders.remove(order);
        finishedOrders.add(order);
        this.world.getPlayer().decLifes();
    }
    
    @Override
    public ArrayList<Order> getCurrentOrders() {
        return currentOrders;
    }

    @Override
    public ArrayList<Order> getFinishedOrders() {
        return finishedOrders;
    }
    
    @Override
    public void startGeneration() {
        generator.startGeneration(INTERVAL_MILLISECONDS);
    }
    
    @Override
    public void stopGeneration() {
        generator.stopGeneration();;
    }

    /**
     * Just need the first correct order that matches
     * @param plate submitted
     * @return
     */
    private Optional<Order> checkOrder(Plate plate) {
        for (Order order : currentOrders) {
            if (order.checkOrder(plate))
                return Optional.ofNullable(order);
        }
        return Optional.empty();
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
        if (currentOrders.size() == 0) {
            generator.generateNewOrder();
        }
    }
}
