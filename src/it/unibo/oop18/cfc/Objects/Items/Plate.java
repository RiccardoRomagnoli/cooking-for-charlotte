package it.unibo.oop18.cfc.Objects.Items;

import java.util.ArrayList;

public interface Plate {
    void addDish(IngredientImpl d);

    IngredientImpl getIngredient(int pos);

    ArrayList<IngredientImpl> getIngredients();

    public boolean checkReady();

    public boolean checkIngredients(ArrayList<OrderIngredient> ingredientsList);
}
