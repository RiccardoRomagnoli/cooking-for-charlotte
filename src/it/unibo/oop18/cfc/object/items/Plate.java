package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;
import java.util.List;

import it.unibo.oop18.cfc.util.Position;

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
     * Draw the plate in the {@link Position} with specific width and height and
     * draw his ingredients on it.
     *
     * @param g      the {@link Graphics2D} of the screen
     * @param p      the {@link Position}
     * @param width  the width
     * @param height the height
     */
    void drawWithIngredients(Graphics2D g, Position p, int width, int height);
}
