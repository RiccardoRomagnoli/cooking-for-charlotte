package it.unibo.oop18.cfc.graphics;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.object.Items.IngredientImpl;
import it.unibo.oop18.cfc.object.Items.IngredientState;
import it.unibo.oop18.cfc.sprite.IngredientSprite;

/**
 * The Class IngredientGraphicComponent.
 */
public class IngredientGraphicComponent implements GraphicsComponent{

    /** The ingredient. */
    private IngredientImpl ingredient;
    
    /** The ingredient sprite. */
    private IngredientSprite ingredientSprite;
    
    

    /**
     * {@inheritDoc}
     */
    public void draw(Graphics2D g) {
        if(ingredient.getState() == IngredientState.RAW) {

        }
    }

}
