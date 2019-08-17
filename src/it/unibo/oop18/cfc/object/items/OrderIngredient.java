package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

/**
 * The Interface OrderIngredient.
 */
public interface OrderIngredient {

    /**
     * Check ingredient.
     *
     * @param ingredient the {@link Ingredient}
     * @return the {@link CheckStatus}
     */
    CheckStatus checkIngredient(Ingredient ingredient);

    /**
     * Draw the ingredient with different dimension.
     *
     * @param g      the {@link Graphics2D} of the screen
     * @param p      the {@link Position}
     * @param width  the width
     * @param height the height
     */
    void draw(Graphics2D g, Position p, int width, int height);
}
