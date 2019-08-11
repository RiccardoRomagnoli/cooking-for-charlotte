package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.Position;

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

    void drawState(final Graphics2D g, final Position p);

    void drawState(Graphics2D g, Position p, int width, int height);
}
