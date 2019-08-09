package it.unibo.oop18.cfc.Objects.Items;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Util.CheckStatus;
import it.unibo.oop18.cfc.Util.Position;

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

    void drawState(final Graphics2D g, final Position p);
}
