package it.unibo.oop18.cfc.CookingStuff;

import java.util.List;

public class Dish {

	private String name;
	private List<Ingredient> ingredients;
	private int points;
	/**
	 * 
	 * @param name: the name of the dish
	 * @param ingredients: the ingredients of which the dish is composed
	 * Dish constructor.
	 */
	public Dish(final String name, final List<Ingredient> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
		this.points = 0;
	}
	private void updatePoints(final int points) {
		this.points += points;
	}
	public boolean checkReady() {
		int max = ingredients.size();
		int counter = 0;
		this.points = 0;
		for (Ingredient i: ingredients) {
			updatePoints(i.getPointsValue());
			if (i.isReady()) {
				counter++;
			}
		}
		if (counter == max) {
			return true;
		}
		return false;
	}
}