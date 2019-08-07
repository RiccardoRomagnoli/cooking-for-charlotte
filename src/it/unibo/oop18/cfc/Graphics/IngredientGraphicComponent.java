package it.unibo.oop18.cfc.Graphics;

import java.awt.Graphics2D;

import it.unibo.oop18.cfc.Objects.Items.IngredientImpl;
import it.unibo.oop18.cfc.Objects.Items.IngredientState;
import it.unibo.oop18.cfc.Sprite.IngredientSprite;

public class IngredientGraphicComponent implements GraphicsComponent{

    IngredientImpl ingredient;
    IngredientSprite ingredientSprite;
    
    
    @Override
    public void draw(Graphics2D g) {
        if(ingredient.getState() == IngredientState.RAW) {

        }
    }

}
