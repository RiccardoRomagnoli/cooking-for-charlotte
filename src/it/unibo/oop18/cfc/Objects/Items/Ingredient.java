package it.unibo.oop18.cfc.Objects.Items;

public interface Ingredient {
    IngredientType getFood();

    IngredientState getState();

    void changeState(IngredientState state);
}
