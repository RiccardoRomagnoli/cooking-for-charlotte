package it.unibo.oop18.cfc.Objects.Items;

import java.util.ArrayList;

public interface Plate {
    void addDish(IngredientImpl d);

    IngredientImpl getIngredient(int pos);

    ArrayList<IngredientImpl> getIngredients();

    boolean checkReady();
}
