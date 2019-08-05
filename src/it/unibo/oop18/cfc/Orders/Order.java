package it.unibo.oop18.cfc.Orders;

import it.unibo.oop18.cfc.Objects.Items.IngredientType;
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
	
	public void addIngredient(IngredientType food, IngredientState ingredientState);
}
