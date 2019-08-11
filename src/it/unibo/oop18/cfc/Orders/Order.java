package it.unibo.oop18.cfc.Orders;

import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.OrderIngredient;

import java.awt.Graphics2D;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.Plate;

public interface Order {

    /**
     * Checks is the plate submitted is the same of the order plate.
     * 
     * @param plate Plate submitted
     * @return True if they are the same
     */
    boolean checkOrder(Plate plate);

    void draw(Graphics2D g);

    int getPoints();

    int getSlot();

    void setSlot(int slot);

    void startOrder();

    int getOrderIngredientQuantity();

    void addIngredient(IngredientType ingredientType, IngredientState ingredientState);

    void setCountDownTimer(int timeInSeconds);

    ArrayList<OrderIngredient> getIngredientsList();

    void stopOrder();

    int getCountDownTime();
}
