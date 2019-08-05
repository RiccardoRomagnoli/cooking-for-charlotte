package it.unibo.oop18.cfc.Recipes;

import java.util.List;

import it.unibo.oop18.cfc.CookingStuff.Ingredient;

public interface Burger {

	/**
	 * @return the list of all the ingredients inside the burger
	 */
	List<Ingredient> getIngredients();
}
