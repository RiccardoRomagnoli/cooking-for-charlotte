package it.unibo.oop18.cfc.Objects.Items;

public interface Plate {
    void addDish(IngredientImpl d);

    IngredientImpl getDish(int pos);

    boolean checkReady();
}
