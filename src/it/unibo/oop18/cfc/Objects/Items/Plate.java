package it.unibo.oop18.cfc.Objects.Items;

import java.util.ArrayList;

public interface Plate {

    void addDish(IngredientImpl d);

    IngredientImpl getDish(int pos);

    ArrayList<IngredientImpl> getDishes();
}
