package it.unibo.oop18.cfc.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Recipes.Recipes;
import it.unibo.oop18.cfc.Util.Pair;

public class OrderGeneratorImpl extends TimerTask implements OrderGenerator {

    private final Timer timer;
    private OrderDifficulty currentDifficulty;
    private final List<Pair<IngredientType, IngredientState>> orderIngredientsAvaiable;
    private final Random random;
    
    public OrderGeneratorImpl() {
        timer = new Timer();
        orderIngredientsAvaiable = new ArrayList<>();
        random = new Random();
        initList();
    }

    @Override
    public void startGeneration(long intervalMilliseconds){
        timer.schedule(new OrderGeneratorImpl(), 0, intervalMilliseconds);
    }
    
    @Override
    public void run() {
        generateNewOrder();
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
    private Order generateNewOrder() {
        Order o = new OrderImpl();
        if(getRandomRecipe().equals(Recipes.BURGER)) {
            o.addIngredient(IngredientType.BREAD, IngredientState.RAW);
        }
        while(o.getOrderIngredientQuantity() - currentDifficulty.getNumberOfIngredients() == 0) {
            int randIng = random.nextInt(orderIngredientsAvaiable.size());
            o.addIngredient(orderIngredientsAvaiable.get(randIng).getFirst(), 
                            orderIngredientsAvaiable.get(randIng).getSecond());
        }
        o.setCountDownTimer(currentDifficulty.getSecondsOfConutDown()*1000);
        return o;
    }
    
    private Recipes getRandomRecipe() {
        if(random.nextBoolean()) {
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
