package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.world.World;

public class OrdersManagerImpl implements OrdersManager {

    private static final long INTERVAL_MILLISECONDS = 30000;
    private final List<Order> currentOrders;
    private final List<Order> finishedOrders;
    private final GameTimer gameTimer;
    private final OrderGenerator generator;
    private final World world;

    public OrdersManagerImpl(final World world) {
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
    public boolean deliveryPlate(final Plate plate) {
        final Optional<Order> order = checkOrder(plate);
        if (order.isPresent()) {
            orderSucceed(order.get());
        } else {
            loseLife();
        }
        return order.isPresent();
    }

    /**
     * delegates draw of each order by setting them their slot which is the index of
     * order list.
     */
    @Override
    public void draw(final Graphics2D g) {
        for (final Order o : this.currentOrders) {
            o.setSlot(currentOrders.indexOf(o));
            o.draw(g);
        }
    }

    @Override
    public void update() {
        // generator(timertask) work with timers that call run
        // this is the alternative solution call every time in update
        // generator.run();
        updateDifficulty();
        checkZeroOrders();
    }

    @Override
    public void addOrder(final Order o) {
        this.currentOrders.add(o);
        this.currentOrders.sort((o1, o2) -> o1.getCountDownTime() - o2.getCountDownTime());
    }

    @Override
    public int getOrderQuantity() {
        return currentOrders.size();
    }

    @Override
    public void orderFailed(final Order order) {
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
        this.loseLife();
    }

    @Override
    public List<Order> getCurrentOrders() {
        return currentOrders;
    }

    @Override
    public List<Order> getFinishedOrders() {
        return finishedOrders;
    }

    @Override
    public void startGeneration() {
        generator.startGeneration(INTERVAL_MILLISECONDS);
    }

    @Override
    public void stopGeneration() {
        generator.stopGeneration();
    }

    /**
     * Just need the first correct order that matches
     * 
     * @param plate submitted
     * @return
     */
    private Optional<Order> checkOrder(final Plate plate) {
        for (final Order order : currentOrders) {
            if (order.checkOrder(plate)) {
                return Optional.ofNullable(order);
            }
        }
        return Optional.empty();
    }

    private void orderSucceed(final Order order) {
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
    }

    private void updateDifficulty() {
        final int currentMinute = (int) gameTimer.getMinutes();
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
        if (currentOrders.isEmpty()) {
            generator.generateNewOrder();
        }
    }

    private void loseLife() {
        this.world.getPlayer().decLifes();
        System.out.println("You just losed a life!!");
    }
}
