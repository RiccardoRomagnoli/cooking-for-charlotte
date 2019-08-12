package it.unibo.oop18.cfc.object.items;

import java.util.List;

public interface Plate {
    void addDish(IngredientImpl d);

    IngredientImpl getIngredient(int pos);

    List<IngredientImpl> getIngredients();

    public boolean checkReady();

    public boolean checkIngredients(List<OrderIngredient> ingredientsList);
}
