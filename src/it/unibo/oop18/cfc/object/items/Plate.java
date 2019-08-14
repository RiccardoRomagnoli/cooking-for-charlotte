package it.unibo.oop18.cfc.object.items;

import java.util.List;

/**
 * The Interface Plate.
 */
public interface Plate {

    /**
     * Adds the Ingredient on the plate.
     *
     * @param d the {@Ingredient}
     */
    void addIngredient(IngredientImpl d);

    /**
     * Gets the ingredient at specific position.
     *
     * @param pos the position on the plate
     * @return the {@link IngredientImpl}
     */
    IngredientImpl getIngredient(int pos);

    /**
     * Gets the list of all ingredients.
     *
     * @return the ingredients list
     */
    List<IngredientImpl> getIngredients();

    /**
     * Check ready.
     *
     * @return true, if successful
     */
    boolean checkReady();

    /**
     * Matches each order Ingredient to each plate ingredient if found a match
     * removes the ingredients matched in the plate if there is no match for just an
     * order ingredient it fails directly.
     *
     * @param ingredientsList List of order ingredients
     * @return true, if successful
     */
    boolean checkIngredients(List<OrderIngredient> ingredientsList);

    /**
     * Clear all the ingredients on the plate.
     */
    void wash();

    /**
     * @return points of the plate
     */
    int getPoints();
}
