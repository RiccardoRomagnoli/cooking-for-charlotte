package it.unibo.oop18.cfc.object.items;

import java.util.ArrayList;

public interface Plate {
    void addDish(IngredientImpl d);

    IngredientImpl getIngredient(int pos);

    ArrayList<IngredientImpl> getIngredients();

    public boolean checkReady();

    public boolean checkIngredients(ArrayList<OrderIngredient> ingredientsList);
}
