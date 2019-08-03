package it.unibo.oop18.cfc.Orders;

import java.util.ArrayList;

import it.unibo.oop18.cfc.CookingStuff.IngredientState;
import it.unibo.oop18.cfc.Objects.Items.Food;
import it.unibo.oop18.cfc.Objects.Items.Plate;
import it.unibo.oop18.cfc.Util.Pair;

public class OrderImpl implements Order {
	
	private final ArrayList<Pair<Food, IngredientState>> plate;
	private int points;
	private int slot; // 1 2 3 4
//	private Timer timer;
//  observer.update on timer ticks
	
	public OrderImpl() {
		plate = new ArrayList<>();
	}

	@Override
	public boolean checkOrder(Plate plate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addIngredient(Food food, IngredientState ingredientState) {
		if(plate.size()>4)
			throw new IllegalStateException();
		plate.add(new Pair<Food, IngredientState>(food, ingredientState));
	}
	
	public void setSlot(int slot) {
		this.slot = slot;
	}

}
