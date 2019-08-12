package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.util.GameScoreImpl;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.world.World;

public class OrdersManagerImpl implements OrdersManager {

    /**
     * TODO. mettere i javadoc sulla interfaccia e qua lasciare solo l'inherit
     * 
     */
    private static final long INTERVAL_MILLISECONDS = 30000;
    private final ArrayList<Order> currentOrders;
    private final ArrayList<Order> finishedOrders;
    private GameTimer gameTimer;
    private final OrderGeneratorImpl generator;
    private final World world;
    private static GameScoreImpl score = new GameScoreImpl();

    public OrdersManagerImpl(World world) {
        this.world = world;
        currentOrders = new ArrayList<>();
        finishedOrders = new ArrayList<>();
        gameTimer = world.getGameTimer();
        generator = new OrderGeneratorImpl(this);
        score.computeScore(0);
    }

    public World getWorld() {
        return world;
    }

    @Override
    public boolean deliveryPlate(Plate plate) {
        Optional<Order> order = checkOrder(plate);
        if (order.isPresent()) {
            orderSucceed(order.get());
        } else {
            loseLife();
        }
        return order.isPresent();
    }

    /**
     * delegates draw of each order by setting them their slot which is the index of
     * order list
     */
    @Override
    public void draw(final Graphics2D g) {
        for (Order o : this.currentOrders) {
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
    public void addOrder(Order o) {
        this.currentOrders.add(o);
        this.currentOrders.sort((o1, o2) -> o1.getCountDownTime() - o2.getCountDownTime());
    }

    /**
     * Get the quantity of order. {@inheritDoc}
     */
    public int getOrderQuantity() {
        return currentOrders.size();
    }

    /**
     * Manage a bad delivered order. {@inheritDoc}
     */
    public void orderFailed(final Order order) {
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
        this.loseLife();
    }

    /**
     * Get the list of current active orders. {@inheritDoc}
     */
    public List<Order> getCurrentOrders() {
        return currentOrders;
    }

    /**
     * Get the list of finisched orders. {@inheritDoc}
     */
    public List<Order> getFinishedOrders() {
        return finishedOrders;
    }

    /**
     * Start the orders generation. {@inheritDoc}
     */
    public void startGeneration() {
        generator.startGeneration(INTERVAL_MILLISECONDS);
    }

    /**
     * Stop the orders generation. {@inheritDoc}
     */
    public void stopGeneration() {
        generator.stopGeneration();
    }

    /**
     * Just need the first correct order that matches.
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

    /**
     * Complete order when it's correct.
     * 
     * @param order created and delivered
     */
    private void orderSucceed(final Order order) {
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
        score.computeScore(10);
    }

    /**
     * Update the difficulty of the game.
     */
    private void updateDifficulty() {
        final int currentMinute = (int) gameTimer.getMinutes();
        OrderDifficulty currentDifficulty = OrderDifficulty.EASY;

        if (currentMinute > 2) {
            currentDifficulty = OrderDifficulty.MEDIUM;
            score.computeScore(100);
        }
        if (currentMinute > 8) {
            currentDifficulty = OrderDifficulty.HARD;
            score.computeScore(400);
        }
        if (currentMinute > 16) {
            currentDifficulty = OrderDifficulty.EXTREME;
            score.computeScore(1000);
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

    /**
     * Return integer of points made during game.
     * 
     * @return int points
     */
    public static int getScore() {
        return score.getScore();
    }
}