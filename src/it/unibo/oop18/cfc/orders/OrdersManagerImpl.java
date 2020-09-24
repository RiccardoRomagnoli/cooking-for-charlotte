package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.unibo.oop18.cfc.gamestate.GameStates;
import it.unibo.oop18.cfc.object.items.Plate;
import it.unibo.oop18.cfc.util.GameScore;
import it.unibo.oop18.cfc.util.GameTimer;
import it.unibo.oop18.cfc.world.World;

/**
 * Order Manager Implementation Class.
 *
 */
public class OrdersManagerImpl implements OrdersManager {

    private static final long INTERVAL_MILLISECONDS = 30000;
    private final GameScore scoreManager;
    private final List<Order> currentOrders;
    private final List<Order> finishedOrders;
    private final GameTimer gameTimer;
    private final OrderGeneratorImpl generator;
    private final World world;

    /**
     * @param world World Instance
     */
    public OrdersManagerImpl(final World world) {
        this.scoreManager = world.getScoreManager();
        this.world = world;
        this.currentOrders = new ArrayList<>();
        this.finishedOrders = new ArrayList<>();
        this.gameTimer = world.getGameTimer();
        this.generator = new OrderGeneratorImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    public World getWorld() {
        return world;
    }

    /**
     * {@inheritDoc}
     */
    public boolean deliveryPlate(final Plate plate) {
        final Optional<Order> order = checkOrder(plate);
        if (order.isPresent()) {
            orderSucceed(order.get(), plate.getPoints());
        }
        return order.isPresent();
    }

    /**
     * delegates draw of each order by setting them their slot which is the index of
     * order list.
     */
    @Override
    public void draw(final Graphics2D g) {
        final List<Order> copyCurrentOrders = new ArrayList<Order>(this.currentOrders);
        for (final Order o : copyCurrentOrders) {
            o.setSlot(currentOrders.indexOf(o));
            o.draw(g);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void update() {
        updateDifficulty();
        checkZeroOrders();
    }

    /**
     * {@inheritDoc}
     */
    public void addOrder(final Order o) {
        this.currentOrders.add(o);
        this.currentOrders.sort((o1, o2) -> o1.getCurrentCountDownTime() - o2.getCurrentCountDownTime());
    }

    /**
     * {@inheritDoc}
     */
    public int getOrderQuantity() {
        return currentOrders.size();
    }

    /**
     * {@inheritDoc}
     */
    public void orderFailed(final Order order) {
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
        this.loseLife();
    }

    /**
     * {@inheritDoc}
     */
    public List<Order> getCurrentOrders() {
        return currentOrders;
    }

    /**
     * {@inheritDoc}
     */
    public List<Order> getFinishedOrders() {
        return finishedOrders;
    }

    /**
     * {@inheritDoc}
     */
    public void startGeneration() {
        generator.startGeneration(INTERVAL_MILLISECONDS);
    }

    /**
     * {@inheritDoc}
     */
    public void stopGeneration() {
        generator.stopGeneration();
    }

    /**
     * {@inheritDoc}
     */
    public void pauseGeneration() {
        this.generator.setPaused(true);
    }

    /**
     * {@inheritDoc}
     */
    public void resumeGeneration() {
        this.generator.setPaused(false);
    }

    /**
     * {@inheritDoc}
     */
    public void pauseOrders() {
        this.getCurrentOrders().stream().forEach(o -> o.setPaused(true));
    }

    /**
     * {@inheritDoc}
     */
    public void resumeOrders() {
        this.getCurrentOrders().stream().forEach(o -> o.setPaused(false));
    }

    /**
     * {@inheritDoc}
     */
    public void stopOrders() {
        this.getCurrentOrders().stream().forEach(o -> o.stopOrder());
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
    private void orderSucceed(final Order order, final int points) {
        scoreManager.computeScore(points);
        order.stopOrder();
        currentOrders.remove(order);
        finishedOrders.add(order);
    }

    /**
     * Update the difficulty of the game.
     */
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
        if (this.world.getPlayer().getLifes() == 0) {
            this.world.getGameStateManager().setState(GameStates.GAMEOVER);
        }
    }
}
