package it.unibo.oop18.cfc.Recipes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import it.unibo.oop18.cfc.CookingStuff.Ingredient;

public class BasicBurger implements Burger{

	private List<Ingredient> burgerList = new LinkedList<Ingredient>();
	@Override
	public List<Ingredient> getIngredients() {
		return this.burgerList;
	}

}
