package it.unibo.oop18.cfc.Orders;

import it.unibo.oop18.cfc.Objects.Items.IngredientType;
import it.unibo.oop18.cfc.Objects.Items.OrderIngredient;

import java.awt.Graphics2D;
import java.util.ArrayList;

import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.Plate;


public interface Order{
    
    /**
     * Checks is the plate submitted is the same of the order plate
     * 
     * @param plate Plate submitted
     * @return True if they are the same
     */
    public boolean checkOrder(Plate plate);
    
    public int getPoints();
    
    public void startOrder();
    
    public int getOrderIngredientQuantity();
    
    public void addIngredient(IngredientType ingredientType, IngredientState ingredientState);
    
    public void setCountDownTimer(int timeInSeconds);

    public ArrayList<OrderIngredient> getIngredientsList();

    public void stopOrder();

    public int getCountDownTime();

    public void setSlot(int slot);
    
    public void draw(Graphics2D g);
}
