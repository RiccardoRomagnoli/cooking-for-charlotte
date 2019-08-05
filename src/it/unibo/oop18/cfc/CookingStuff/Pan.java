package it.unibo.oop18.cfc.CookingStuff;

import it.unibo.oop18.cfc.Objects.Items.IngredientState;

/**
 * a cookware used to cook one ingredient.
 *
 */
public class Pan implements Cookware {
	
	private final int MAX_IN_PAN = 1;
	private Ingredient ingInPan;
	private boolean cooking;
	private long startCooking;
	private long endCooking;
	private long elapsedTime;
	
	@Override
	public void add(Ingredient ing) {
		if (!this.isFull() && ing.getState() == IngredientState.CHOPPED && !ing.isRawGood()) {
			this.ingInPan = ing;
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

	@Override
	public boolean isFull() {
		return this.ingInPan != null;
	}
	
}
