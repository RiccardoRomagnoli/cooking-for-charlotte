package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Interface OrderIngredient.
 */
public interface OrderIngredient {

    /**
     * Gets the ingredient.
     *
     * @return the type of the ingredient
     */
    IngredientType getIngredient();

    /**
     * Gets the state.
     *
     * @return the current state of the Ingredient
     */
    IngredientState getState();

    /**
     * Check ingredient.
     *
     * @param ingredient the {@link Ingredient}
     * @return the {@link CheckStatus}
     */
    CheckStatus checkIngredient(Ingredient ingredient);

    /**
     * Check if ingredient state match his state.
     * 
     * @return true, if match
     */
    boolean isReady();

    /**
     * Draw the ingredient.
     *
     * @param g the {@link Graphics2D} of the screen
     * @param p the {@link Position}
     */
    void draw(Graphics2D g, Position p);

    /**
     * Draw the ingredient with different dimension.
     *
     * @param g the {@link Graphics2D} of the screen
     * @param p the {@link Position}
     * @param width the width
     * @param height the height
     */
    void draw(Graphics2D g, Position p, int width, int height);
}
