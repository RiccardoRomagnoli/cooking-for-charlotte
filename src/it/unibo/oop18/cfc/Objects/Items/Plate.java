package it.unibo.oop18.cfc.Objects.Items;

public interface Plate {
    public void addDish(IngredientImpl d);

    public IngredientImpl getDish(int pos);
}
