package it.unibo.oop18.cfc.object.items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.util.CheckStatus;
import it.unibo.oop18.cfc.util.Position;

public interface OrderIngredient {
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
    
    CheckStatus checkIngredient(Ingredient ingredient);

    void draw(final Graphics2D g, final Position p);
    
    void draw(Graphics2D g, Position p, int width, int height);
}
