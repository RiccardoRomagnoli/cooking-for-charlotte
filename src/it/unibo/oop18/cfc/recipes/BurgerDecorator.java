package it.unibo.oop18.cfc.recipes;

import java.util.List;

import it.unibo.oop18.cfc.cookingstuff.Ingredient;

public abstract class BurgerDecorator implements Burger {

	protected final Burger decorated;
	
	protected BurgerDecorator(Burger decorated) {
		this.decorated = decorated;
	}

	@Override
	public List<Ingredient> getIngredients() {
		return decorated.getIngredients();
	}
}
