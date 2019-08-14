package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.Position;

/**
 * The Interface Ingredient.
 */
public interface Ingredient {

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
     * Change state.
     *
     * @param state the {@link IngredientState}
     */
    void changeState(IngredientState state);
}
