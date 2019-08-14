package it.unibo.oop18.cfc.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.util.Pair;

/**
 * Order Generator Implementation Class.
 *
 */
public class OrderGeneratorImpl extends TimerTask implements OrderGenerator {

    private Timer timer;
    private OrderDifficulty currentDifficulty;
    private final List<Pair<IngredientType, IngredientState>> orderIngredientsAvaiable;
    private final Random random;
    private final OrdersManager ordersManager;
    private boolean paused;

    /**
     * @param ordersManager Order Manager Istance
     */
    public OrderGeneratorImpl(final OrdersManager ordersManager) {
        super();
        this.ordersManager = ordersManager;
        this.timer = new Timer();
        this.orderIngredientsAvaiable = new ArrayList<>();
        this.random = new Random();
        this.currentDifficulty = OrderDifficulty.EASY;
        this.paused = false;
        initList();
    }


    /**
    * {@inheritDoc}
    */
    public void startGeneration(final long intervalMilliseconds) {
        this.timer = new Timer();
        this.timer.schedule(this, 0, intervalMilliseconds);
    }

    /**
    * {@inheritDoc}
    */
    public void stopGeneration() {
        this.timer.cancel();
        this.timer.purge();
    }

    /**
    * {@inheritDoc}
    */
    public void setPaused(final boolean paused) {
        this.paused = paused;
    }

    /**
    * {@inheritDoc}
    */
    public void run() {
        if (!paused && ordersManager.getOrderQuantity() != 4) {
            generateNewOrder();
        }
    }

    /**
    * {@inheritDoc}
    */
    public void setDifficulty(final OrderDifficulty difficulty) {
        currentDifficulty = difficulty;
    }

    /**
     * Generate a new random Order based on difficulty.
     * 
     */
    public void generateNewOrder() {
        if (ordersManager.getOrderQuantity() != 4) {
            final Order o = new OrderImpl(ordersManager);
            o.setSlot(ordersManager.getOrderQuantity());
            if (getRandomRecipe().equals(Recipes.BURGER)) {
                o.addIngredient(IngredientType.BREAD, IngredientState.CHOPPED);
            }
            while (o.getOrderIngredientQuantity() - currentDifficulty.getNumberOfIngredients() != 0) {
                final int randIng = random.nextInt(orderIngredientsAvaiable.size());
                o.addIngredient(orderIngredientsAvaiable.get(randIng).getFirst(),
                        orderIngredientsAvaiable.get(randIng).getSecond());
            }
            o.setCountDownTimer(currentDifficulty.getSecondsOfConutDown());
            o.startOrder();
            ordersManager.addOrder(o);
        }
    }

    private Recipes getRandomRecipe() {
        if (random.nextBoolean()) {
            return Recipes.BURGER;
        }
        return Recipes.SIMPLE_PLATE;
    }

    private void initList() {
        orderIngredientsAvaiable.add(new Pair<>(IngredientType.LETTUCE, IngredientState.CHOPPED));
        orderIngredientsAvaiable.add(new Pair<>(IngredientType.TOMATO, IngredientState.CHOPPED));
        orderIngredientsAvaiable.add(new Pair<>(IngredientType.MEAT, IngredientState.PERFECT));
    }
}
