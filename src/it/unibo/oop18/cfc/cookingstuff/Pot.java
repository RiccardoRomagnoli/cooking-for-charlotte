package it.unibo.oop18.cfc.cookingstuff;

import java.util.LinkedList;
import java.util.List;

import it.unibo.oop18.cfc.object.Items.IngredientState;
/**
 * a cookware used to cook more then one ingredient.
 */
public class Pot implements Cookware {

	private final int MAX_IN_POT;
	private List<Ingredient> cookingIngredients; 
	private int ingInPot;
	private boolean cooking;
	private long startCooking;
	private long endCooking;
	private long elapsedTime;
	
	public Pot(final int maxIng) {
		this.MAX_IN_POT = maxIng;
		this.cookingIngredients = new LinkedList<>();
		this.ingInPot = 0;
		this.cooking = false;
	}
	public void add(Ingredient ing) {
		if (!this.isFull() && ing.getState() == IngredientState.CHOPPED && !ing.isRawGood()) {
			this.ingInPot++;
			this.cookingIngredients.add(ing);
			//you can add ingredients while cooking and by doing so 
			//the cooking restarts for all the ingredients
			for (Ingredient i : cookingIngredients) {
				i.restartCooking();
			}
			if (this.cooking) {
				this.startCooking = System.nanoTime();
				this.elapsedTime = 0;
			}
		} else {
			System.out.println("you can't add another ingredient!!");
		}
	}
	@Override
	public void cook() {
		this.cooking = !this.cooking;
		if (this.cooking) {
			this.startCooking = System.nanoTime();
		} else {
			this.endCooking = System.nanoTime();
			long passedTime = endCooking - startCooking;
			this.elapsedTime += passedTime; 
		}
	}
	public boolean isFull() {
		return this.ingInPot >= this.MAX_IN_POT;
	}
}
