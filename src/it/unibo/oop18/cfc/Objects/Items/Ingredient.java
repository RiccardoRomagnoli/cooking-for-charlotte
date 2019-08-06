package it.unibo.oop18.cfc.Objects.Items;

public interface Ingredient {
    /**
     * 
     * @return the type of the ingredient
     */
    IngredientType getIngredient();
    /** 
     * 
     * @return the current state of the Ingredient
     */
    IngredientState getState();
    /**
     * 
     * @param state: the state in which the ingredient will be changed
     */
    void changeState(IngredientState state);
}
