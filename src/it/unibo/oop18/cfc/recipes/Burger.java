package it.unibo.oop18.cfc.recipes;

import java.util.List;

import it.unibo.oop18.cfc.cookingstuff.Ingredient;

public interface Burger {

	/**
	 * @return the list of all the ingredients inside the burger
	 */
	List<Ingredient> getIngredients();
}
