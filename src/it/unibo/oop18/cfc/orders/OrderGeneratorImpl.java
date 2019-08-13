package it.unibo.oop18.cfc.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.util.Pair;

public class OrderGeneratorImpl extends TimerTask implements OrderGenerator {

    private Timer timer;
    private OrderDifficulty currentDifficulty;
    private final List<Pair<IngredientType, IngredientState>> orderIngredientsAvaiable;
    private final Random random;
    private final OrdersManager ordersManager;
    private boolean paused;

    public OrderGeneratorImpl(OrdersManager ordersManager) {
        this.ordersManager = ordersManager;
        this.timer = new Timer();
        this.orderIngredientsAvaiable = new ArrayList<>();
        this.random = new Random();
        this.currentDifficulty = OrderDifficulty.EASY;
        this.paused = false;
        initList();
    }

    @Override
    public void startGeneration(long intervalMilliseconds) {
        this.timer = new Timer();
        this.timer.schedule(this, 0, intervalMilliseconds);
    }
    
    @Override
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    @Override
    public void run() {
        if(!paused) {
            if (ordersManager.getOrderQuantity() != 4) {
                generateNewOrder();
            }
        }
    }

    @Override
    public void setDifficulty(OrderDifficulty difficulty) {
        currentDifficulty = difficulty;
    }

    /**
     * Generate a new random Order based on difficulty
     * 
     * @return Order generated
     */
    public void generateNewOrder() {
        if (ordersManager.getOrderQuantity() != 4) {
            Order o = new OrderImpl(ordersManager);
            o.setSlot(ordersManager.getOrderQuantity());
            if (getRandomRecipe().equals(Recipes.BURGER)) {
                o.addIngredient(IngredientType.BREAD, IngredientState.CHOPPED);
            }
            while (o.getOrderIngredientQuantity() - currentDifficulty.getNumberOfIngredients() != 0) {
                int randIng = random.nextInt(orderIngredientsAvaiable.size());
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

    public void stopGeneration() {
        // TODO Auto-generated method stub
        
    }
}
