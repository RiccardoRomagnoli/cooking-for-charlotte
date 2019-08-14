package it.unibo.oop18.cfc.orders;

import java.awt.Graphics2D;
import java.util.List;

import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.object.items.OrderIngredient;
import it.unibo.oop18.cfc.object.items.Plate;

/**
 * The Interface Order.
 *
 */
public interface Order {

    /**
     * Checks is the plate submitted is the same of the order plate.
     * 
     * @param plate Plate submitted
     * @return True if they are the same
     */
    boolean checkOrder(Plate plate);

    /**
     * Start the Order Timer.
     */
    void startOrder();

    /**
     * Gets the number of ingredients in an Order.
     * 
     * @return N° of Ingredients
     */
    int getOrderIngredientQuantity();

    /**
     * Add Ingredient to the Order.
     * 
     * @param ingredientType Ingrediente
     * @param ingredientState Stato dell'Ingrediente
     */ 
    void addIngredient(IngredientType ingredientType, IngredientState ingredientState);

    /**
     * Sets the Timers seconds.
     * 
     * @param timeInSeconds Seconds before the Order Expires
     */
    void setCountDownTimer(int timeInSeconds);

    /**
     * Get seconds remained before the Order Expires.
     * 
     * @return Seconds
     */
    int getCountDownTime();

    /**
     * Set's the Order Slot.
     * 
     * @param slot Order Slot
     */
    void setSlot(int slot);

    /**
     * Delegates to the {@link GraphicComponent} the draw of the order.
     * @param g Image 2D
     */
    void draw(Graphics2D g);

    /**
     * Return the Slot.
     * @return Slot
     */
    int getSlot();

    /**
     * @return List of Ingredients
     */
    List<OrderIngredient> getIngredientsList();

    /**
     * 
     */
    void stopOrder();

    /**
     * Set in Pause state the timer.
     * @param paused true to set pause
     */
    void setPaused(boolean paused);
}
