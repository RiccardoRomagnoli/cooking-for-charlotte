package it.unibo.oop18.cfc.test;

import it.unibo.oop18.cfc.manager.GameStateManager;
import it.unibo.oop18.cfc.manager.ItemManager;
import it.unibo.oop18.cfc.object.items.Ingredient;
import it.unibo.oop18.cfc.object.items.IngredientImpl;
import it.unibo.oop18.cfc.object.items.IngredientState;
import it.unibo.oop18.cfc.object.items.IngredientType;
import it.unibo.oop18.cfc.world.World;
import it.unibo.oop18.cfc.world.WorldImpl;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

/**
 * This class test some Ingredient features like .
 */
public class TestIngredient {

    /**
     * This class test some ingredient features, such the creation and the state
     * changing.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testIngredientCreation() throws IOException {
          final World world = new WorldImpl(new GameStateManager()); 
          final ItemManager im = world.getItemManager();
          // creation of the ingredients
          final Ingredient bread = new IngredientImpl(im, IngredientType.BREAD);
          final Ingredient lettuce = new IngredientImpl(im, IngredientType.LETTUCE);
          final Ingredient tomato = new IngredientImpl(im, IngredientType.TOMATO);
          final Ingredient meat = new IngredientImpl(im, IngredientType.MEAT);
          final Ingredient cookedMeat = new IngredientImpl(im, IngredientType.MEAT, IngredientState.PERFECT);
          //testing the right creation
          Assert.assertTrue(bread.getState() == IngredientState.RAW);
          Assert.assertTrue(lettuce.getState() == IngredientState.RAW);
          Assert.assertTrue(tomato.getState() == IngredientState.RAW);
          Assert.assertTrue(meat.getState() == IngredientState.RAW);
          Assert.assertTrue(cookedMeat.getState() == IngredientState.PERFECT);
          //testing that the points are right
          Assert.assertTrue(bread.getState().getPoints() == IngredientState.RAW.getPoints());
          Assert.assertTrue(lettuce.getState().getPoints() == IngredientState.RAW.getPoints());
          Assert.assertTrue(tomato.getState().getPoints() == IngredientState.RAW.getPoints());
          Assert.assertTrue(meat.getState().getPoints() == IngredientState.RAW.getPoints());
          Assert.assertTrue(cookedMeat.getState().getPoints() == IngredientState.PERFECT.getPoints());
          //testing that the states change right 
          bread.changeState(IngredientState.CHOPPED);
          lettuce.changeState(IngredientState.CHOPPED);
          tomato.changeState(IngredientState.CHOPPED);
          meat.changeState(IngredientState.PERFECT);
          Assert.assertTrue(bread.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(lettuce.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(tomato.getState() == IngredientState.CHOPPED);
          Assert.assertTrue(meat.getState() == IngredientState.PERFECT);
          //testing that the changes are right
          Assert.assertTrue(bread.getState().getPoints() == IngredientState.CHOPPED.getPoints());
          Assert.assertTrue(lettuce.getState().getPoints() == IngredientState.CHOPPED.getPoints());
          Assert.assertTrue(tomato.getState().getPoints() == IngredientState.CHOPPED.getPoints());
          Assert.assertTrue(meat.getState().getPoints() == IngredientState.PERFECT.getPoints());
    }
}
